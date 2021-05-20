package com.xjt.mimall.controller;

import com.xjt.mimall.vo.ResponseVO;
import com.xjt.mimall.enums.ResponseEnum;
import com.xjt.mimall.exception.ServiceException;
import com.xjt.mimall.service.IUserService;
import com.xjt.mimall.dto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/register")
    public ResponseVO saveUser(@RequestBody RegisterDTO RegisterDTO){

        if(StringUtils.isEmpty(RegisterDTO)){
            throw new ServiceException(ResponseEnum.USER_IS_NULL);
        }
        iUserService.saveUser(RegisterDTO);

        return ResponseVO.success(ResponseEnum.REGISTRY_SUCCESS);
    }
}
