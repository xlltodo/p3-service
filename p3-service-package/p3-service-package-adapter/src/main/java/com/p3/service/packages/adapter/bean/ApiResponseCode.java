package com.p3.service.packages.adapter.bean;

/**
 * Api响应码
 * */
public enum ApiResponseCode {
    /**
     * 成功
     * */
    SUCCESS(200),
    /**
     * 失败
     * */
    FAIL(500),
    /**
     * 未授权
     * */
    UNAUTHORIZED(401),
    /**
     * 禁止访问
     * */
    FORBIDDEN(403);

    private final Integer code;

    public Integer getCode() {
        return code;
    }

    ApiResponseCode(Integer code) {
        this.code = code;
    }
}
