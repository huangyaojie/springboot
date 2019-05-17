package com.example.springboot.service;

import com.example.springboot.pojo.ProductCategory;

public interface ProductCategoryService {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}
