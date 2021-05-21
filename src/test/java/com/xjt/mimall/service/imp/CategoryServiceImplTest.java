package com.xjt.mimall.service.imp;

import com.xjt.mimall.MiMallApplicationTests;
import com.xjt.mimall.config.BeanConfig;
import com.xjt.mimall.service.ICategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CategoryServiceImplTest extends MiMallApplicationTests {


    @Autowired
    private ICategoryService iCategoryService;

    @Test
    public void getCategories() {

        System.out.println(iCategoryService.getCategories());
    }
}