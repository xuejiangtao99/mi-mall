package com.xjt.mimall.util;

import com.alibaba.fastjson.JSON;


/**
 * json 与 Java 互换
 */
public class JsonUtil {

    //java-json
    public  static <T>String toJson(T obj){

        return JSON.toJSONString(obj);
    }

    //json ->java
    public static <T>T toBean(String json,Class<T> clazz){

        return  JSON.parseObject(json,clazz);
    }

}
