package com.p3.signal.bridge.activator.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

public interface RoutingFilter extends WebFilter {

    Mono<Void> forwardRequest(ServerHttpRequestDecorator request, ServerWebExchange exchange);
}
