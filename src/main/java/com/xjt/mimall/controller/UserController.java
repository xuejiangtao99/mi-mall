package com.xjt.mimall.controller;

import com.xjt.mimall.config.BeanConfig;
import com.xjt.mimall.dto.LoginDTO;
import com.xjt.mimall.util.ObjectUtils;
import com.xjt.mimall.util.cache.RedisUtils;
import com.xjt.mimall.vo.ResponseVO;
import com.xjt.mimall.enums.ResponseEnum;
import com.xjt.mimall.exception.ServiceException;
import com.xjt.mimall.service.IUserService;
import com.xjt.mimall.dto.RegisterDTO;
import com.xjt.mimall.vo.UserResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService iUserService;

    private RedisUtils redisUtils = BeanConfig.getBean(RedisUtils.class);

    @PostMapping("/register")
    public ResponseVO saveUser(@Valid @RequestBody RegisterDTO registerDTO
                               ){

        iUserService.saveUser(registerDTO);

        return ResponseVO.success(ResponseEnum.REGISTRY_SUCCESS);
    }

    @PostMapping("/login")
    public ResponseVO login(@Valid @RequestBody LoginDTO loginDTO){

        UserResponseVO login = iUserService.login(loginDTO);

        return ResponseVO.success(ResponseEnum.LOGIN_SUCCESS,login);
    }



    @GetMapping("/login/{token}")
    public ResponseVO getUserInfo(@PathVariable("token") String token){

        UserResponseVO userResponseVO = redisUtils.get(token, UserResponseVO.class);

        if(ObjectUtils.isNull(userResponseVO)){

            throw new ServiceException(ResponseEnum.LOGIN_EXPIRED_OR_USER_NOT_LOGIN);
        }

        return ResponseVO.success(ResponseEnum.SYSTEM_SUCCESS,userResponseVO);
    }


    @PostMapping("/logout/{token}")
    public ResponseVO logout(@PathVariable("token") String token){

        UserResponseVO userResponseVO = redisUtils.get(token, UserResponseVO.class);

        if(ObjectUtils.isNull(userResponseVO)){

            throw new ServiceException(ResponseEnum.LOGIN_EXPIRED_OR_USER_NOT_LOGIN);
        }

        return ResponseVO.success(ResponseEnum.LOG_OUT_SUCCESS);
    }
}
