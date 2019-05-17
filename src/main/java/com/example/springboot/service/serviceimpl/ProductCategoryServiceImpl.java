package com.example.springboot.service.serviceimpl;

import com.example.springboot.mapper.ProductCategoryMapper;
import com.example.springboot.pojo.ProductCategory;
import com.example.springboot.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer categoryId) {
        return 0;
    }

    @Override
    public int insert(ProductCategory record) {
        return productCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(ProductCategory record) {
        return 0;
    }

    @Override
    public ProductCategory selectByPrimaryKey(Integer categoryId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(ProductCategory record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ProductCategory record) {
        return 0;
    }
}
