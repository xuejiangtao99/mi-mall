package com.xjt.mimall.vo;

import com.xjt.mimall.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO<T> {

    private Integer status;

    private String msg;

    private T data;


    public ResponseVO(Integer code, String message) {

        this.status = code;
        this.msg = message;
    }

    public static ResponseVO success(ResponseEnum responseEnum){

        return new ResponseVO(responseEnum.getCode(), responseEnum.getMsg());
    }

    public static ResponseVO error(ResponseEnum responseEnum){

        return new ResponseVO(responseEnum.getCode(), responseEnum.getMsg());
    }
}
