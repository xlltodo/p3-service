package com.p3.signal.bridge.activator.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.p3.signal.bridge.activator.bean.dto.RemoteServiceResponse;
import com.p3.signal.bridge.activator.bean.dto.RequestDataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class HttpRoutingFilter implements RoutingFilter {

    private final ObjectMapper objectMapper;
    private final WebClient webClient;

    @Autowired
    public HttpRoutingFilter(ObjectMapper objectMapper, WebClient.Builder webClientBuilder) {
        this.objectMapper = objectMapper;
        this.webClient = webClientBuilder.build();
    }


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return collectRequestData(exchange)
                .flatMap(this::sendToRemoteService)
                .flatMap(response -> {
                    if (response.isStatus()) {
                        return forwardAndFilter(exchange, chain);
                    } else {
                        return Mono.empty();
                    }
                });
    }

    private Mono<RequestDataDTO> collectRequestData(ServerWebExchange exchange) {
        RequestDataDTO requestDataDTO = new RequestDataDTO();

        // 收集请求头信息
        try {
            String headersJson = this.objectMapper.writeValueAsString(exchange.getRequest().getHeaders().toSingleValueMap());
            requestDataDTO.setHeaders(headersJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        requestDataDTO.setMethod(exchange.getRequest().getMethod().name());
        requestDataDTO.setUri(exchange.getRequest().getURI().getRawPath());

        // 创建一个用于存储新DataBuffer的列表
        List<DataBuffer> dataBuffers = new ArrayList<>();

        // 收集请求体信息
        return Flux.from(exchange.getRequest().getBody())
                .flatMap(dataBuffer -> {
                    // 读取DataBuffer中的数据并转换为String
                    byte[] bytes = new byte[dataBuffer.readableByteCount()];
                    dataBuffer.read(bytes);
                    String body = new String(bytes, StandardCharsets.UTF_8);
                    requestDataDTO.setBody(body);

                    // 将读取到的数据重新封装回新的DataBuffer，并添加到列表中
                    DataBuffer newDataBuffer = exchange.getResponse().bufferFactory().wrap(bytes);
                    dataBuffers.add(newDataBuffer);

                    return Mono.just(newDataBuffer);
                })
                .then(Mono.defer(() -> {
                    // 保存新的DataBuffer流以供后续使用
                    exchange.getAttributes().put("modifiedRequestBody", dataBuffers);
                    return Mono.just(requestDataDTO);
                }));
    }


    private Mono<RemoteServiceResponse> sendToRemoteService(RequestDataDTO requestDataDTO) {

        return this.webClient.post()
                .uri("http://localhost:8080/request/save")
                .bodyValue(requestDataDTO)
                .retrieve()
                .bodyToMono(RemoteServiceResponse.class); // 假设RemoteServiceResponse是远程服务响应的类
    }

    private Mono<Void> forwardAndFilter(ServerWebExchange exchange, WebFilterChain chain) {
        // 从属性中获取保存的DataBuffer列表
        List<DataBuffer> dataBuffers = exchange.getAttribute("modifiedRequestBody");

        // 创建新的ServerHttpRequestDecorator来替换请求体
        ServerHttpRequestDecorator decoratedRequest = new ServerHttpRequestDecorator(exchange.getRequest()) {
            @Override
            public Flux<DataBuffer> getBody() {
                return Flux.fromIterable(dataBuffers);
            }
        };

        // 将修改后的请求传递给过滤链的下一个元素
        return forwardRequest(decoratedRequest, exchange)
                .then(chain.filter(exchange.mutate().request(decoratedRequest).build()));
    }


    @Override
    public Mono<Void> forwardRequest(ServerHttpRequestDecorator request, ServerWebExchange exchange) {

        // 获取原始请求的URI和查询参数
        URI originalUri = request.getURI();
        String query = originalUri.getQuery();
        String forwardUrl = "http://localhost:8080/test"; // 目标服务的URL

        // 如果存在查询参数，将它们附加到转发URL上
        if (query != null && !query.isEmpty()) {
            forwardUrl = forwardUrl + "?" + query;
        }

        System.out.println("Forwarding to URL: " + forwardUrl);

        return this.webClient.method(request.getMethod())
                .uri(forwardUrl)
                .headers(headers -> headers.addAll(request.getHeaders()))
                .body(BodyInserters.fromDataBuffers(request.getBody()))
                .exchangeToMono(clientResponse -> {
                    // 将目标服务的响应状态和头部信息写回原始响应
                    exchange.getResponse().setStatusCode(clientResponse.statusCode());
                    exchange.getResponse().getHeaders().addAll(clientResponse.headers().asHttpHeaders());

                    // 将目标服务的响应体写回原始响应
                    return clientResponse.bodyToMono(DataBuffer.class)
                            .flatMap(dataBuffer -> exchange.getResponse().writeWith(Mono.just(dataBuffer)));
                });
    }
}
