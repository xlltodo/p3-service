package com.p3.service.packages.infrastructure.event.publisher;

import com.p3.service.packages.domain.event.base.SyncOutOfProcessBaseDomainEvent;
import com.p3.service.packages.domain.publisher.ISyncOutOfProcessEventPublisher;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SyncOutOfProcessEventPublisher implements ISyncOutOfProcessEventPublisher {

    private final WebClient webClient;

    public SyncOutOfProcessEventPublisher(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Override
    public void publish(SyncOutOfProcessBaseDomainEvent event) {

        WebClient.RequestHeadersSpec<?> requestSpec;
        if (event.getHttpMethod().equals(HttpMethod.GET)) {
            requestSpec = webClient.get().uri(event.getServiceUri());
        } else if (event.getHttpMethod().equals(HttpMethod.POST)) {
            requestSpec = webClient.post().uri(event.getServiceUri()).bodyValue(event);
        } else {
            throw new IllegalArgumentException("Unsupported HTTP method: " + event.getHttpMethod());
        }

        requestSpec.retrieve().bodyToMono(Void.class).block();
    }
}
