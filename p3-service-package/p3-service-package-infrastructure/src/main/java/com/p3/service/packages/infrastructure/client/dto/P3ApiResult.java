package com.p3.service.packages.infrastructure.client.dto;


import lombok.Data;

@Data
public class P3ApiResult<T> {

    private Integer code;

    private T data;

    private String msg;
}
