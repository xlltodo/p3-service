package com.p3.service.packages.infrastructure.event.publisher;

import com.p3.service.packages.domain.event.base.SyncInProcessBaseDomainEvent;
import com.p3.service.packages.domain.publisher.ISyncInProcessEventPublisher;
import jakarta.annotation.Resource;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SyncInProcessEventPublisher implements ISyncInProcessEventPublisher {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish(SyncInProcessBaseDomainEvent event) {

        applicationEventPublisher.publishEvent(event);
    }
}
