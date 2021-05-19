package com.xjt.mimall.service.imp;

import com.xjt.mimall.MiMallApplicationTests;
import com.xjt.mimall.service.IUserService;
import com.xjt.mimall.vo.RegisterVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserViceImplTest extends MiMallApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void testSaveUser(){
        RegisterVO registerVO = new RegisterVO("ruiWen","123456","15503595314@163.com");

        userService.saveUser(registerVO);

    }
}