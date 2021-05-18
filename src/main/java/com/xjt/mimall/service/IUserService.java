package com.xjt.mimall.service;

import com.xjt.mimall.vo.RegisterVO;

public interface IUserService {


    /**
     * 新增用户/注册
     * @param registerVO
     */
   void saveUser(RegisterVO registerVO);
   
}
