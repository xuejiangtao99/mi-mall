package com.xjt.mimall.config;


import com.xjt.mimall.enums.ResponseEnum;
import com.xjt.mimall.exception.ServiceException;
import com.xjt.mimall.util.ObjectUtils;
import com.xjt.mimall.util.cache.RedisUtils;
import com.xjt.mimall.vo.UserResponseVO;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginInterceptor implements HandlerInterceptor {

    private RedisUtils redisUtils = BeanConfig.getBean(RedisUtils.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //preFlight请求，忽略本拦截器
        if (CorsUtils.isPreFlightRequest(request)){

            return true;
        }

        String token = request.getHeader("accessToken");

        if(StringUtils.hasLength(token)){
            throw new ServiceException(ResponseEnum.USER_IS_NOT_LOGIN);

        }else{

            UserResponseVO userResponseVO = redisUtils.get(token, UserResponseVO.class);
            if(ObjectUtils.isNull(userResponseVO)){
                throw new ServiceException(ResponseEnum.USER_IS_NOT_LOGIN);

            }
        }
        return true;
    }


    //渲染响应内容
//    private void renderResponseContent(HttpServletResponse response){
//        response.setContentType("application/json;charset=utf-8");
//
//        try {
//            PrintWriter writer =response.getWriter();
//            writer.println(JsonUtil.toJson(ResponseVO.error(ResponseEnum.USER_IS_NOT_LOGIN)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
