package com.xjt.mimall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseVO {

    private String id;

    private String username;

    private String email;

    private String phone;

    private Integer role;

    private Date createTime;

    private Date updateTime;
}
