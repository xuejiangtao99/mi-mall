package com.xjt.mimall.mapper;

import com.xjt.mimall.pojo.MallCategory;
import com.xjt.mimall.pojo.MallCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallCategoryMapper {
    long countByExample(MallCategoryExample example);

    int deleteByExample(MallCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MallCategory record);

    int insertSelective(MallCategory record);

    List<MallCategory> selectByExample(MallCategoryExample example);

    MallCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MallCategory record, @Param("example") MallCategoryExample example);

    int updateByExample(@Param("record") MallCategory record, @Param("example") MallCategoryExample example);

    int updateByPrimaryKeySelective(MallCategory record);

    int updateByPrimaryKey(MallCategory record);
}