package com.xjt.mimall.exception;


import com.xjt.mimall.enums.ResponseEnum;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException{

    private Integer code;

    /**
     * 已知错误
     * @param responseEnum
     */
    public ServiceException(ResponseEnum responseEnum){
        super(responseEnum.getMsg());

        this.code = responseEnum.getCode();
    }

    /**
     * 自定义错误类型
     * @param status
     * @param msg
     */
    public ServiceException(Integer status,String msg){
        super(msg);
        this.code = status;
    }

}
