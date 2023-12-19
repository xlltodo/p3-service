package com.p3.signal.bridge.activator.bean.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class RequestDataDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -7851523759968355714L;

    private String uri;
    private String headers;
    private String method;
    private String body;
}
