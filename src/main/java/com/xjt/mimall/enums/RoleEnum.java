package com.xjt.mimall.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleEnum {

    ADMIN_ROLE(0),

    ORDINARY_ROLE(1);

    private Integer role;
}
