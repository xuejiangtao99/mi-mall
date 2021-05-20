package com.xjt.mimall.util.cache;

import com.xjt.mimall.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@Service
public class RedisUtils {

    @Autowired
    private JedisPool jedisPool;

    /**
     *
     * @param key redis key
     * @param value redis 值
     * @param seconds 存储多久
     * @param <T>
     */
    //设置setex
    public <T> void setex(String key,T value,int seconds){
        Jedis resource = null;
        try{
            resource = jedisPool.getResource();
            String json = beanToString(value);
            //调用redis命令
            resource.setex(key,seconds,json);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            resource.close();
        }
    }

    /**
     *
     * @param key 键
     * @param value 值
     * @param <T>
     */
    public <T> void set(String key,T value){
        Jedis resource = null;
        try{
            resource = jedisPool.getResource();
            String json = beanToString(value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            resource.close();
        }
    }


    /**
     *
     * @param key 键
     * @param clazz 返回值类型
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz){
        Jedis resource = null;
        T t = null;
        try{
            resource = jedisPool.getResource();
            String json = resource.get(key);
            if(json == null){
                return null;
            }
            t = stringToBean(json,clazz);
            //调用redis命令
            resource.set(key,json);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            resource.close();
        }
        return t;
    }



    //string - > java
    private <T> T stringToBean(String json,Class<T> clazz) {
        T resault = null;
        if(clazz == int.class || clazz == Integer.class){
            resault = (T)Integer.valueOf(json);
        }else if(clazz == String.class){
            resault = (T)json;
        }else if (clazz == long.class || clazz == Long.class){
            resault = (T)Long.valueOf(json);
        }else {
            resault = JsonUtil.toBean(json,clazz);
        }
        return  resault;
    }

    //将java对象 --> json
    private <T> String beanToString(T value) {
        String resault = null;
        Class<?> clazz = value.getClass();
        if(clazz == int.class || clazz == Integer.class){
            resault = String.valueOf(value);
        }else if(clazz == String.class){
            resault = (String) value;
        }else if (clazz == long.class || clazz == Long.class){
            resault = String.valueOf(value);
        }else {
            resault= JsonUtil.toJson(value);
        }

        return resault;
    }
}
