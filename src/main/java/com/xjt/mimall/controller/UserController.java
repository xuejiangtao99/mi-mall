package com.xjt.mimall.controller;

import com.xjt.mimall.util.ObjectUtils;
import com.xjt.mimall.vo.ResponseVO;
import com.xjt.mimall.enums.ResponseEnum;
import com.xjt.mimall.exception.ServiceException;
import com.xjt.mimall.service.IUserService;
import com.xjt.mimall.dto.RegisterDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/register")
    public ResponseVO saveUser(@Valid @RequestBody RegisterDTO RegisterDTO
                               ){
        if(ObjectUtils.isNull(RegisterDTO)){
            throw new ServiceException(ResponseEnum.USER_IS_NULL);
        }
        iUserService.saveUser(RegisterDTO);

        return ResponseVO.success(ResponseEnum.REGISTRY_SUCCESS);
    }
}
