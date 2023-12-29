package com.p3.service.packages.domain.publisher;

import com.p3.service.packages.domain.event.base.SyncOutOfProcessBaseDomainEvent;

public interface ISyncOutOfProcessEventPublisher {

    void publish(SyncOutOfProcessBaseDomainEvent event);
}
