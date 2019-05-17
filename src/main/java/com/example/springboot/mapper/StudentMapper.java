package com.example.springboot.mapper;

import com.example.springboot.pojo.Student;


public interface StudentMapper {
   //学生查询列表
    Student findStudentsByID(Long id)
            throws Exception;

}
