package com.xjt.mimall.util;


import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;

public class Md5Util {

    public static String md5(String src){

        return DigestUtils.md5DigestAsHex((src).getBytes(Charset.forName("utf-8")));
    }
}
