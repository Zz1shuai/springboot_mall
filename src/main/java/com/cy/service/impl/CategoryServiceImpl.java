package com.cy.service.impl;

import com.cy.consts.MallConst;
import com.cy.dao.CategoryMapper;
import com.cy.pojo.Category;
import com.cy.service.ICategoryService;
import com.cy.vo.CategoryVo;
import com.cy.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * @Create by 猪小帅
 * @date 2022/3/24 14:11
 * @mood happy
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ResponseVo<List<CategoryVo>> selectAll() {
        List<CategoryVo> categoryVoList = new ArrayList<>();
        List<Category> categories = categoryMapper.selectAll();

        //查出parent_id=0
        for (Category category : categories) {
            if (category.getParentId().equals(MallConst.ROOT_PARENT_ID)) {
                CategoryVo categoryVo = new CategoryVo();
                BeanUtils.copyProperties(category, categoryVo);
                categoryVoList.add(categoryVo);
            }
        }

        categoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());

        //lambda + stream
//        List<CategoryVo> categoryVoList = categories.stream()
//                .filter(e -> e.getParentId().equals(MallConst.ROOT_PARENT_ID))
//                .map(this::category2CategoryVo)
//                .sorted(Comparator.comparing(CategoryVo::getSortOrder).reversed())
//                .collect(Collectors.toList());

        //查询子目录
        findSubCategory(categoryVoList, categories);


        return ResponseVo.success(categoryVoList);
    }

    @Override
    public void findSubCategoryId(Integer id, Set<Integer> resultSet) {
        List<Category> categories = categoryMapper.selectAll();
        findSubCategoryId(id, resultSet, categories);
    }

    private void findSubCategoryId(Integer id, Set<Integer> resultSet, List<Category> categories) {
        for (Category category : categories) {
            if (category.getParentId().equals(id)) {
                resultSet.add(category.getId());
                findSubCategoryId(category.getId(), resultSet, categories);
            }
        }
    }

    private void findSubCategory(List<CategoryVo> categoryVoList, List<Category> categories) {
        for (CategoryVo categoryVo : categoryVoList) {
            List<CategoryVo> subCategoryVoList = new ArrayList<>();
            for (Category category : categories) {
                //如果查到内容，设置SubCategory，继续往下查
                if (categoryVo.getId().equals(category.getParentId())) {
                    CategoryVo subCategoryVo = category2CategoryVo(category);
                    subCategoryVoList.add(subCategoryVo);
                }

                //二级目录
                subCategoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
                categoryVo.setSubCategories(subCategoryVoList);

                //三级目录
                findSubCategory(subCategoryVoList, categories);
            }
        }
    }
    private CategoryVo category2CategoryVo(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }
}
