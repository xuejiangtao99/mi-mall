package com.xjt.mimall.service.imp;

import com.xjt.mimall.mapper.MallUserMapper;
import com.xjt.mimall.pojo.MallUser;
import com.xjt.mimall.pojo.MallUserExample;
import com.xjt.mimall.service.IUserService;
import com.xjt.mimall.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserViceImpl implements IUserService {

    @Autowired
    private MallUserMapper mallUserMapper;

    @Override
    public void saveUser(RegisterVO registerVO) {

        MallUser mallUser = mallUserMapper.selectByUser(registerVO);

        if(!StringUtils.isEmpty(mallUser)){

        }
    }
}
