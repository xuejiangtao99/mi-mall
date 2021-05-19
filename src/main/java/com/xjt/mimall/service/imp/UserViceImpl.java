package com.xjt.mimall.service.imp;

import com.xjt.mimall.enums.ResponseEnum;
import com.xjt.mimall.enums.RoleEnum;
import com.xjt.mimall.exception.ServiceException;
import com.xjt.mimall.mapper.MallUserMapper;
import com.xjt.mimall.pojo.MallUser;
import com.xjt.mimall.service.IUserService;
import com.xjt.mimall.util.CopyUtil;
import com.xjt.mimall.util.UuidUtil;
import com.xjt.mimall.vo.RegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;
import java.util.Date;

@Service
public class UserViceImpl implements IUserService {

    @Autowired
    private MallUserMapper mallUserMapper;

    private final String SALT = "qwer!@#$1234";

    /**
     * 注册
     * @param registerVO
     */
    @Override
    public void saveUser(RegisterVO registerVO) {

        //判断邮箱和用户名
        int countUsername = mallUserMapper.countSelectByUsername(registerVO.getUsername());

        int countEmail = mallUserMapper.countSelectByEmail(registerVO.getEmail());

        if(countUsername > 0){
            throw new ServiceException(ResponseEnum.USER_EXITS);
        }

        if(countEmail > 0 ){

            throw new ServiceException(ResponseEnum.EMAIL_EXITS);
        }

        //MD5 + 密 + 盐
        registerVO.setPassword(DigestUtils.md5DigestAsHex((registerVO.getPassword() + SALT).getBytes(Charset.forName("utf-8"))));

        MallUser mallUser = CopyUtil.copyObject(registerVO, MallUser.class);

        mallUser.setRole(RoleEnum.ORDINARY_ROLE.getRole());

        mallUser.setId(UuidUtil.getShortUuid());

        mallUser.setCreateTime(new Date());
        mallUser.setUpdateTime(new Date());
        //写入数据库
        mallUserMapper.insert(mallUser);

    }
}
