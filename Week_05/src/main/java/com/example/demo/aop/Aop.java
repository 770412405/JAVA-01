package com.example.demo.aop;

import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: 肖震
 * @date: 2021/2/21
 * @since:
 */
@Component
@Aspect
public class Aop {
    @Pointcut("execution(* com.example.demo.spring.bean.Animal.state(..))")
    void point(){
    }

    @Before(value="point()")
    void before(){
        System.out.println("前置通知");
    }


    @After(value = "point()")
    void after(){
        System.out.println("后置通知");
    }

    //这个参数是动态传入的
    @Around(value = "point()")
    void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("执行前");
        joinPoint.proceed();
        System.out.println("执行后");
    }

}
