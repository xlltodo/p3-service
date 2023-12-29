package com.p3.service.packages.domain.publisher;

import com.p3.service.packages.domain.event.base.SyncInProcessBaseDomainEvent;

public interface ISyncInProcessEventPublisher  {

    void publish(SyncInProcessBaseDomainEvent event);
}
