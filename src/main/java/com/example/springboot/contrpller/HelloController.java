package com.example.springboot.contrpller;

import com.example.springboot.pojo.Student;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    public String index(){
        System.out.println("hello spring boot");
        return "index";
    }

    @RequestMapping("/hello")
    public String toIndex(){
        System.out.println("hello spring boot1");
        return "index";
    }
    /*用户页面*/
    @RequestMapping("/add")
    public String useradd(){
        System.out.println("hello spring boot");
        return "/user/add";
    }
    @RequestMapping("/update")
    public String userupdate(){
        System.out.println("hello spring boot");
        return "/user/update";
    }

    /*登录界面*/
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    /*登录*/
    @RequestMapping(value = "/login")
    public String login(String name,String password, Model model){
        logger.info("-------------------进入登录逻辑------------------------------");
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token=new UsernamePasswordToken(name,password);
        try {
              subject.login(token);
            /*  return "index";*/
            return "redirect:/hello";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名错误");
            e.printStackTrace();
            return "login";
        }  catch (IncorrectCredentialsException e) {
            model.addAttribute("msg","密码错误");
            e.printStackTrace();
            return "login";
        }
    }

    @RequestMapping("/students.html")
    public String students(Map<String,Object> map){
        List<Student> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            Student student = new Student();
            student.setName("张三"+i);
            student.setAge(23+i);
            list.add(student);
        }
        map.put("sList",list);// 返回给页面的数据
        logger.info("studentList: {}",list);
        return "students";
    }

    @RequestMapping("/student/{name}.html")
    public String student(@PathVariable(name="name") String name, Map<String,Object> map){
        Student student = new Student();
        student.setName(name);
        student.setAge(23);
        map.put("student",student);
        return "studentController";
    }




}
