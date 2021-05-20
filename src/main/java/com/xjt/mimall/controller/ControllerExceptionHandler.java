package com.xjt.mimall.controller;

import com.xjt.mimall.enums.ResponseEnum;
import com.xjt.mimall.vo.ResponseVO;
import com.xjt.mimall.exception.ServiceException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(ServiceException.class)
    public ResponseVO handle(ServiceException se){


        return new ResponseVO(se.getCode(),se.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseVO validException(MethodArgumentNotValidException e){

        BindingResult bindingResult = e.getBindingResult();
        Objects.requireNonNull(bindingResult.getFieldError());
        return new ResponseVO().error(ResponseEnum.PARAM_ERROR,bindingResult.getFieldError().getField() + "" + bindingResult.getFieldError().getDefaultMessage());
    }

}
