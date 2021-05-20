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

    private ResponseVO(Integer code, String message) {

        this.status = code;
        this.msg = message;
    }

    public static ResponseVO success(ResponseEnum responseEnum){

        return new ResponseVO(responseEnum.getCode(), responseEnum.getMsg());
    }


    public static ResponseVO success(ResponseEnum responseEnum,Object data){

        return new ResponseVO(responseEnum.getCode(), responseEnum.getMsg(),data);
    }


    public static ResponseVO error(ResponseEnum responseEnum,String msg){

        return new ResponseVO(responseEnum.getCode(),msg);
    }


    public static ResponseVO error(Integer code,String msg){

        return new ResponseVO(code,msg);
    }
}
