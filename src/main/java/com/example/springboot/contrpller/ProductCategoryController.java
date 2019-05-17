package com.example.springboot.contrpller;

import com.example.springboot.pojo.ProductCategory;
import com.example.springboot.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCategoryController {


    @Autowired
    private ProductCategoryService productCategoryService;


    @RequestMapping(path = {"/insertProductCategory"},method = RequestMethod.GET)
    public  int insert(){
        ProductCategory record = new ProductCategory("女生最爱", 4);
      /*  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());*/
       /* record.setCreateTime(new Date());
        record.setUpdateTime(new Date());*/
        int  i = 0;
        try {
            i = productCategoryService.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }




}
