package com.p3.service.packages.adapter.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author lltodo
 */
@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    /**
     * 字段校验异常响应捕获
     * */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiResponse<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        e.printStackTrace();
        log.error(e.getMessage());
        StringBuilder errors = new StringBuilder();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.append(error.getField() + ": " + error.getDefaultMessage() + ";");
        }
        return ApiResponse.fail(errors.toString());
    }

    /**
     * 空指针异常响应捕获
     * */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ApiResponse<String> nullPointerExceptionHandler(NullPointerException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return ApiResponse.fail(e.getStackTrace()[0].getClassName() + ": " + e.getStackTrace()[0].getLineNumber() + "行，发生空指针错误！");
    }

    /**
     * 超时异常响应捕获
     * */
    @ExceptionHandler(TimeoutException.class)
    @ResponseBody
    public ApiResponse<String> timeoutExceptionHandler(TimeoutException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return ApiResponse.fail("该请求响应超时！");
    }

    /**
     * 其他异常捕获（放在最后）
     * */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResponse<String> exceptionHandler(Exception e){
        e.printStackTrace();
        log.error(e.getMessage());
        return ApiResponse.fail("未定义异常！");
    }
}
