package com.xjt.mimall.controller;

import com.xjt.mimall.dto.ResponseDTO;
import com.xjt.mimall.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseDTO handle(ServiceException se){


        return new ResponseDTO(se.getCode(),se.getMessage());
    }
}
