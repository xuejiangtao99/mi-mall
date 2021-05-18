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


    /*系统10000*/
    SYSTEM_SUCCESS(200,"成功"),
    SYSTEM_ERROR(10001,"系统异常"),

    /*20000用户*/
    USER_EXITS(20001,"用户已经存在");
    private Integer code;

    private String msg;

}
