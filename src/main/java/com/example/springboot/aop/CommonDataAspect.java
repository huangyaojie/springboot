package com.example.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class CommonDataAspect {
    private static final Logger logger = LoggerFactory.getLogger(CommonDataAspect.class);

    private static final String CREATOR     = "creator";
    private static final String MODIFIER    = "modifier";
    private static final String GMTCREATE   = "createTime";
    private static final String GMTMODIFIED = "updateTime";


    @Pointcut("execution( *  com.example.springboot.mapper.*.insert*(..))")
    public  void  insertCutMethod(){
    }

   /* @Around("insertCutMethod()")
    public Object doInsertAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            logger.debug("[insert]"+arg);
        }
        Object o = pjp.proceed();
        return o;
    }*/

   @Before("insertCutMethod()")
    public void beforeInsert(JoinPoint jp) {
       logger.info("AOP ------------------------------- before");
        Object[] args = jp.getArgs();

        if (args != null && args.length > 0) {
            Object argument = args[0];
            BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
            logger.info("AOP ------------------------------- before +添加创建时间和更新时间");

            if (beanWrapper.isWritableProperty(GMTCREATE)) {
                beanWrapper.setPropertyValue(GMTCREATE, new Date());
            }
            if (beanWrapper.isWritableProperty(GMTMODIFIED)) {
                beanWrapper.setPropertyValue(GMTMODIFIED, new Date());
            }
            logger.info("AOP ------------------------------- before +添加创建时间和更新时间"+new Date());

            // 设置创建人和修改人
         /*   if (beanWrapper.isWritableProperty(CREATOR) && privilegeInfo != null
                    && StringUtils.isNotBlank(privilegeInfo.getWorkNo())) {
                beanWrapper.setPropertyValue(CREATOR, privilegeInfo.getWorkNo());
            }
            if (beanWrapper.isWritableProperty(MODIFIER) && privilegeInfo != null
                    && StringUtils.isNotBlank(privilegeInfo.getWorkNo())) {
                beanWrapper.setPropertyValue(MODIFIER, privilegeInfo.getWorkNo());
            }*/
        }
    }


    @AfterReturning(returning = "ret", pointcut = "insertCutMethod()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        //.out.println("方法的返回值 : " + ret);
        logger.info("AOP ------------------------------- after returning");

    }

    //后置异常通知
    @AfterThrowing("insertCutMethod()")
    public void throwss(JoinPoint jp){
      //  System.out.println("方法异常时执行.....");
        logger.info("AOP ------------------------------- after throwing ");

    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("insertCutMethod()")
    public void after(JoinPoint jp){
     //   System.out.println("方法最后执行.....");
        logger.info("AOP ------------------------------- after");
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("insertCutMethod()")
    public Object arround(ProceedingJoinPoint pjp) {

     //   System.out.println("方法环绕start.....");
        try {
            logger.info("AOP -------------------------------around    start");
            Object o =  pjp.proceed();
           // System.out.println("方法环绕proceed，结果是 :" + o);
            logger.info("AOP -------------------------------around  end"+ o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }


}
