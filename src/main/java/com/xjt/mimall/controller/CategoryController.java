package com.xjt.mimall.controller;

import com.xjt.mimall.enums.ResponseEnum;
import com.xjt.mimall.service.ICategoryService;
import com.xjt.mimall.vo.CategoryVO;
import com.xjt.mimall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/categories")
    public ResponseVO getCategories(){

        List<CategoryVO> categories = iCategoryService.getCategories();

        return ResponseVO.success(ResponseEnum.SYSTEM_SUCCESS,categories);
    }
}
