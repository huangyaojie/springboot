package com.example.springboot.mapper;

import com.example.springboot.pojo.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

   /* @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }*/

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("男生最爱", 4);
        int i = productCategoryMapper.insert(productCategory);
        Assert.assertNotEquals(0, i);
    }

  /*   @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3,4);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }*/
}