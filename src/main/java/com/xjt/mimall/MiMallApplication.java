package com.xjt.mimall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xjt.mimall.mapper")
public class MiMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiMallApplication.class, args);
    }

}
