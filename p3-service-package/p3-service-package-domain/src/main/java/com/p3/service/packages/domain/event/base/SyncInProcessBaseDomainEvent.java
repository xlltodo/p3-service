package com.p3.service.packages.domain.event.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class SyncInProcessBaseDomainEvent extends ApplicationEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = 4373552417031660850L;

    private String eventId;

    public SyncInProcessBaseDomainEvent(String eventId) {
        super(eventId);
    }
}
