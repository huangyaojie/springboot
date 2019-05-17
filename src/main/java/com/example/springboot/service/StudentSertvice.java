package com.example.springboot.service;

import com.example.springboot.pojo.Student;


public interface StudentSertvice {

 Student findStudentsByID(Long  id);
}
