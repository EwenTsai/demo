package com.example.demo.common.handler;

import com.example.demo.controller.response.ResponseObject;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理方法参数校验异常
     * @param e BindException
     * @return { result }
     */
    @ExceptionHandler(BindException.class)
    public ResponseObject<?> handleBindException(BindException e) {
        return ResponseObject.validateFailed(Objects.requireNonNull(e.getFieldError()).getDefaultMessage());
    }

}
