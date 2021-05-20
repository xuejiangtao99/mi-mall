package com.xjt.mimall.service.imp;

import com.xjt.mimall.enums.ResponseEnum;
import com.xjt.mimall.enums.RoleEnum;
import com.xjt.mimall.exception.ServiceException;
import com.xjt.mimall.mapper.MallUserMapper;
import com.xjt.mimall.pojo.MallUser;
import com.xjt.mimall.service.IUserService;
import com.xjt.mimall.util.CopyUtil;
import com.xjt.mimall.util.UuidUtil;
import com.xjt.mimall.dto.RegisterDTO;
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
     * @param RegisterDTO
     */
    @Override
    public void saveUser(RegisterDTO RegisterDTO) {

        //判断邮箱和用户名
        int countUsername = mallUserMapper.countSelectByUsername(RegisterDTO.getUsername());

        int countEmail = mallUserMapper.countSelectByEmail(RegisterDTO.getEmail());

        if(countUsername > 0){
            throw new ServiceException(ResponseEnum.USER_EXITS);
        }

        if(countEmail > 0 ){

            throw new ServiceException(ResponseEnum.EMAIL_EXITS);
        }

        //MD5 + 密 + 盐
        RegisterDTO.setPassword(DigestUtils.md5DigestAsHex((RegisterDTO.getPassword() + SALT).getBytes(Charset.forName("utf-8"))));

        MallUser mallUser = CopyUtil.copyObject(RegisterDTO, MallUser.class);

        mallUser.setRole(RoleEnum.ORDINARY_ROLE.getRole());

        mallUser.setId(UuidUtil.getShortUuid());

        mallUser.setCreateTime(new Date());
        mallUser.setUpdateTime(new Date());
        //写入数据库
        mallUserMapper.insert(mallUser);

    }
}
