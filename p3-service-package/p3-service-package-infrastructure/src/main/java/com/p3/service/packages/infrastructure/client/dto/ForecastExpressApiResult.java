package com.p3.service.packages.infrastructure.client.dto;


import lombok.Data;

@Data
public class ForecastExpressApiResult<T> {

    private Integer code;

    private T data;

    private String msg;
}
