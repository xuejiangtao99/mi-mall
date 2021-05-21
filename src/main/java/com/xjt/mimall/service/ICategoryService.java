package com.xjt.mimall.service;

import com.xjt.mimall.vo.CategoryVO;

import java.util.List;

public interface ICategoryService {

    /**
     * 查询商品类目
     * @return
     */
    List<CategoryVO> getCategories();
}
