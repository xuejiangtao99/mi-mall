package com.xjt.mimall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NotBlank
public class RegisterVO {

    private String username;

    private String password;

    private String email;
}
