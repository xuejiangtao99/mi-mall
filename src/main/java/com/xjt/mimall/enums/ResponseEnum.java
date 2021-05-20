package com.xjt.mimall.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/***
 * 所有成功返回code都为200
 * @author XueJiangTao
 * @date 2021/5/17
 * @param
 * @return
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {

    SYSTEM_SUCCESS(200,"成功"),
    REGISTRY_SUCCESS(200,"用户注册成功"),
    LOGIN_SUCCESS(200,"登录成功"),

    /*系统10000*/
    SYSTEM_ERROR(-1,"服务端异常"),

    /*20000用户*/
    USER_EXITS(20001,"用户已经存在"),
    EMAIL_EXITS(20002,"邮箱已经存在"),
    USERNAME_OR_PASSWORD_ERROR(20005,"用户名或者密码错误"),
    USER_IS_NULL(20003,"用户为空"),
    USER_IS_NOT_LOGIN(20004,"用户未登录,请先登录"),
    /*30000参数*/
    PARAM_ERROR(30001,"参数异常");
    private Integer code;

    private String msg;

}
