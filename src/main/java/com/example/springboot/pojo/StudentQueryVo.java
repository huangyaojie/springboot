package com.example.springboot.pojo;

import java.util.List;

public class StudentQueryVo {
    private String name;
    private Integer age;
    private List<Student> list;

    public StudentQueryVo() {
    }

    public StudentQueryVo(String name, Integer age, List<Student> list) {
        this.name = name;
        this.age = age;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}
