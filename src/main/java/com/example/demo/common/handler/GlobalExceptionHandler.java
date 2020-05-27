package com.example.demo.common.handler;

import com.example.demo.common.util.Result;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * 统一拦截控制层全局异常
 * 返回自定义结果
 * @author Roy Chen
 * @version 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理方法参数校验异常
     * @param e BindException
     * @return { result }
     */
    @ExceptionHandler(BindException.class)
    public Result<?> handleBindException(BindException e) {
        return Result.validateFailed(Objects.requireNonNull(e.getFieldError()).getDefaultMessage());
    }

}
