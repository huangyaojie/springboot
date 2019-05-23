package com.example.springboot.contrpller;

import com.alibaba.fastjson.JSON;
import com.example.springboot.pojo.Student;
import com.example.springboot.service.StudentSertvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

@Autowired
private StudentSertvice studentSertvice;

        Logger logger = LoggerFactory.getLogger(getClass());


        /**
         * 通过设置RequestMapping的method属性便可以设置该方法可处理的对应请求了，例如下面的getRequestDemo方法只会处理get请求
         */
        @RequestMapping(path = {"/getStudents"}, method = RequestMethod.GET)
        public String getStudents(@RequestParam(required = false) Student stu) {
            if (null!=stu){
                logger.info("search  condition :"+stu.getName()+":"+stu.getAge());}
            else{
                logger.info("search  condition is null ");
            }
           /* Student student = new Student();
            student.setName("Student1");
            student.setAge(22);*/
            /*开启分页*/
          //  PageHelper.startPage(1,10);
            Student s = studentSertvice.findStudentsByID(new Long(1));
            logger.info("student:"+s.toString());
            return JSON.toJSONString(s);
        }

 /*   @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public String getStudents(@PathVariable Long  id) {
        Student s = studentSertvice.findStudentsByID(id);
        logger.info("student:"+s.toString());
        return JSON.toJSONString(s);
    }*/


        /**
         * 下面的deleteRequestDemo方法只会处理delete请求
         */
        @RequestMapping(path = {"/addStudents"}, method = RequestMethod.POST)
        public String addStudents(@RequestParam(required = true) List<Student> sList) {
            if (null!=sList){
                logger.info("add condition :"+sList.size());}
            return "add";
        }


    }
