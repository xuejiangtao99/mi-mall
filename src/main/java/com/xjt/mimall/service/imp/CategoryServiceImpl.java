package com.xjt.mimall.service.imp;

import com.xjt.mimall.mapper.MallCategoryMapper;
import com.xjt.mimall.pojo.MallCategory;
import com.xjt.mimall.pojo.MallCategoryExample;
import com.xjt.mimall.service.ICategoryService;
import com.xjt.mimall.util.CopyUtil;
import com.xjt.mimall.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private MallCategoryMapper categoryMapper;

    @Override
    public List<CategoryVO> getCategories() {

        List<MallCategory> mallCategories = categoryMapper.selectByExample(new MallCategoryExample());


        List<MallCategory> parent = mallCategories.stream().filter(
                item -> item.getParentId() == 0).collect(Collectors.toList());

        List<CategoryVO> list = CopyUtil.copyList(parent, CategoryVO.class);

        List<CategoryVO> subCategories = getSubCategories(list, mallCategories);

        return subCategories;
    }

    /**
     * 查询子类目
     * @param list
     * @param collect
     * @return
     */
    private List<CategoryVO> getSubCategories(List<CategoryVO> list,List<MallCategory> collect){


        for(CategoryVO categoryVO:list){

            List<CategoryVO> subCategories =  new ArrayList<>();

            for(MallCategory category:collect){
                if(category.getParentId().equals(categoryVO.getId())){
                    subCategories.add(CopyUtil.copyObject(category, CategoryVO.class));
                }

                categoryVO.setSubCategories(subCategories);
                getSubCategories(subCategories,collect);
            }
        }

        return list;
    }

}
