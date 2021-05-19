package com.xjt.mimall.dto;

import com.xjt.mimall.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {

    private Integer status;

    private String msg;

    private T data;


    public ResponseDTO(Integer code, String message) {

        this.status = code;
        this.msg = message;
    }

    public static ResponseDTO success(ResponseEnum responseEnum){

        return new ResponseDTO(responseEnum.getCode(), responseEnum.getMsg());
    }
}
