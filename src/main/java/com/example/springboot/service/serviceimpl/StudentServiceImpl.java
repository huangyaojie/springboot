package com.example.springboot.service.serviceimpl;

import com.example.springboot.mapper.StudentMapper;
import com.example.springboot.pojo.Student;
import com.example.springboot.service.StudentSertvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class StudentServiceImpl implements StudentSertvice {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findStudentsByID(Long id) {
        Student s  = null;
        try {
            s = studentMapper.findStudentsByID(id);
            logger.info("get the student by id "+s.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
