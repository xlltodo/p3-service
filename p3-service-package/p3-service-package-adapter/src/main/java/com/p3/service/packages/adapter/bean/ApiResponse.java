package com.p3.service.packages.adapter.bean;

import java.io.Serial;
import java.io.Serializable;

public class ApiResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -5608249808727360452L;

    /**
     * Api响应码
     * */
    private Integer code;

    /**
     * Api响应数据
     * */
    private T data;

    /**
     * Api响应信息
     * */
    private String message;

    public Integer getCode() {
        return code;
    }

    public ApiResponse<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ApiResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ApiResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * 成功
     * */
    public static <T> ApiResponse<T> R(T d) {
        return ApiResponse.success(d);
    }

    /**
     * 成功
     * */
    public static <T> ApiResponse<T> success() {
        return new ApiResponse<T>()
                .setCode(ApiResponseCode.SUCCESS.getCode())
                .setData(null)
                .setMessage(ApiResponseMessage.SUCCESS_MESSAGE);
    }

    /**
     * 成功 自定义响应数据
     * @param data 响应数据
     * */
    public static <T> ApiResponse<T> success(T data){
        return new ApiResponse<T>()
                .setCode(ApiResponseCode.SUCCESS.getCode())
                .setData(data)
                .setMessage(ApiResponseMessage.SUCCESS_MESSAGE);
    }

    /**
     * 成功 自定义响应数据及信息
     * @param data 响应数据
     * @param message 响应信息
     * */
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<T>()
                .setCode(ApiResponseCode.SUCCESS.getCode())
                .setData(data)
                .setMessage(message);
    }

    /**
     * 失败
     * */
    public static <T> ApiResponse<T> fail() {
        return new ApiResponse<T>()
                .setCode(ApiResponseCode.FAIL.getCode())
                .setData(null)
                .setMessage(ApiResponseMessage.FAIL_MESSAGE);
    }

    /**
     * 失败 自定义响应码
     * @param apiResponseCode Api响应码
     * */
    public static <T> ApiResponse<T> fail(ApiResponseCode apiResponseCode) {
        return new ApiResponse<T>()
                .setCode(apiResponseCode.getCode())
                .setData(null)
                .setMessage(ApiResponseMessage.FAIL_MESSAGE);
    }

    /**
     * 失败 自定义响应信息
     * @param message 响应信息
     * */
    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<T>()
                .setCode(ApiResponseCode.FAIL.getCode())
                .setData(null)
                .setMessage(message);
    }

    /**
     * 失败 自定义响应码及响应信息
     * @param apiResponseCode Api响应码
     * @param message 响应信息
     * */
    public static <T> ApiResponse<T> fail(ApiResponseCode apiResponseCode, String message) {
        return new ApiResponse<T>()
                .setCode(apiResponseCode.getCode())
                .setData(null)
                .setMessage(message);
    }

    /**
     * Api响应信息
     * */
    public interface ApiResponseMessage {

        String SUCCESS_MESSAGE = "请求成功！";

        String FAIL_MESSAGE = "请求失败！";
    }
}
