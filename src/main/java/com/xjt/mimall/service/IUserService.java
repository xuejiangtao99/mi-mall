package com.xjt.mimall.service;

import com.xjt.mimall.dto.LoginDTO;
import com.xjt.mimall.dto.RegisterDTO;
import com.xjt.mimall.vo.UserResponseVO;

public interface IUserService {


    /**
     * 新增用户/注册
     * @param RegisterDTO
     */
   void saveUser(RegisterDTO RegisterDTO);

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    UserResponseVO login(LoginDTO loginDTO);
   
}
