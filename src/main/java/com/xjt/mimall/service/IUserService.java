package com.xjt.mimall.service;

import com.xjt.mimall.dto.RegisterDTO;

public interface IUserService {


    /**
     * 新增用户/注册
     * @param RegisterDTO
     */
   void saveUser(RegisterDTO RegisterDTO);
   
}
