package com.p3.signal.bridge.activator.bean.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

@Data
public class RemoteServiceResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -6777403110282727909L;

    private boolean status;
}
