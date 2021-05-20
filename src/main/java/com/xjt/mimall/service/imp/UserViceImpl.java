package com.xjt.mimall.service.imp;

import com.xjt.mimall.config.BeanConfig;
import com.xjt.mimall.dto.LoginDTO;
import com.xjt.mimall.enums.ResponseEnum;
import com.xjt.mimall.enums.RoleEnum;
import com.xjt.mimall.exception.ServiceException;
import com.xjt.mimall.mapper.MallUserMapper;
import com.xjt.mimall.pojo.MallUser;
import com.xjt.mimall.service.IUserService;
import com.xjt.mimall.util.CopyUtil;
import com.xjt.mimall.util.Md5Util;
import com.xjt.mimall.util.ObjectUtils;
import com.xjt.mimall.util.UuidUtil;
import com.xjt.mimall.dto.RegisterDTO;
import com.xjt.mimall.util.cache.RedisUtils;
import com.xjt.mimall.vo.UserResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;
import java.util.Date;

@Service
public class UserViceImpl implements IUserService {

    @Autowired
    private MallUserMapper mallUserMapper;

    private RedisUtils redisUtils = BeanConfig.getBean(RedisUtils.class);

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

        //MD5
        RegisterDTO.setPassword(Md5Util.md5(RegisterDTO.getPassword()));

        MallUser mallUser = CopyUtil.copyObject(RegisterDTO, MallUser.class);

        mallUser.setRole(RoleEnum.ORDINARY_ROLE.getRole());

        mallUser.setId(UuidUtil.getShortUuid());

        mallUser.setCreateTime(new Date());
        mallUser.setUpdateTime(new Date());
        //写入数据库
        mallUserMapper.insert(mallUser);

    }

    @Override
    public UserResponseVO login(LoginDTO loginDTO) {
        MallUser mallUser = mallUserMapper.selectByUsername(loginDTO.getUsername());

        //用户不存在
        if(ObjectUtils.isNull(mallUser)){
            throw new ServiceException(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        //密码错误
        if(!(Md5Util.md5(loginDTO.getPassword()) != mallUser.getPassword()
                || Md5Util.md5(loginDTO.getUsername()).equalsIgnoreCase(mallUser.getPassword())
        )){
            throw new ServiceException(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        UserResponseVO userResponseVO = CopyUtil.copyObject(mallUser, UserResponseVO.class);

        String token = UuidUtil.getShortUuid();

        //写入redis 3600s
        redisUtils.setex(token,userResponseVO,36 * 100);

        userResponseVO.setToken(token);
        return userResponseVO;
    }

    /**
     * 根据ID获取用户名
     * @param id
     * @return
     */
    private UserResponseVO getUser(String id) {

        MallUser mallUser = mallUserMapper.selectByPrimaryKey(id);

        if(ObjectUtils.isNull(mallUser)){
            throw new ServiceException(ResponseEnum.NOT_HAS_USER);
        }

        UserResponseVO userResponseVO = CopyUtil.copyObject(mallUser, UserResponseVO.class);

        return userResponseVO;
    }
}
