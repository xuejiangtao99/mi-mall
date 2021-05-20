package com.xjt.mimall.service.imp;

import com.xjt.mimall.MiMallApplicationTests;
import com.xjt.mimall.service.IUserService;
import com.xjt.mimall.dto.RegisterDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserViceImplTest extends MiMallApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void testSaveUser(){
        RegisterDTO RegisterDTO = new RegisterDTO("ruiWen","123456","15503595314@163.com");

        userService.saveUser(RegisterDTO);

    }
}