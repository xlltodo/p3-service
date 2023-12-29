package com.p3.service.packages.domain.event.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class SyncOutOfProcessBaseDomainEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = 8102527644674162964L;

    private String serviceUri;

    private HttpMethod httpMethod;

    private String eventId;
}
