package com.example.demo.dome1;

import com.example.demo.dome1.ClassAll;
import com.example.demo.dome1.Student;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;

/**
 * @author: 肖震
 * @date: 2021/2/21
 * @since:
 */
public class Bean {
    public static void main(String[] args) {
        //以Xml方式注入,单例模式
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Student student1 = (Student) context.getBean("student1");
        student1.info();
        Student student2 = (Student) context.getBean("student2");
        student2.info();
        ClassAll classAll = (ClassAll) context.getBean("class_all");
        classAll.info();
        /**
         *param 要扫描的包，其中包括配置类和容器 注释 :@Configuration 和@Component
         *
         * 在类上加@Component可以将其划归容器管理，在其中一个方法上加入@PostConstruct方法可以在init方法前，bean容器创建后，为bean容器赋值，
         *
         * 在配置类的方法上加@bean ，会将方法返回的类实例管理起来
         * */
        ApplicationContext context1 = new AnnotationConfigApplicationContext("com.example.demo.config",
                "com.example.demo.spring.bean");
        Student student3 = (Student) context1.getBean("student3");
        student3.info();

        Student student4 = (Student) context1.getBean("student4");
        student4.info();

        ClassAll classAll2 = (ClassAll) context1.getBean("class_all");
        classAll2.info();


        // beanDefinition 方式注入
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //配置方法1
        ConstructorArgumentValues agrs = new ConstructorArgumentValues();
        agrs.addIndexedArgumentValue(0, 5);
        agrs.addIndexedArgumentValue(0, "len");
        agrs.addIndexedArgumentValue(0, "null");
        AbstractBeanDefinition student5 = new RootBeanDefinition(Student.class, agrs, null);
        factory.registerBeanDefinition("student5", student5);
        //配置方法2
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("name", "C");
        propertyValues.addPropertyValue("students", Collections.singletonList(new Student(5, "Nata", "C")));
        AbstractBeanDefinition classAll1 = new RootBeanDefinition(ClassAll.class, null, propertyValues);
        factory.registerBeanDefinition("class_all", classAll1);
        //get bean
        Student student6 = (Student) factory.getBean("student5");
        student6.info();
        ClassAll classAll3 = (ClassAll) factory.getBean("class_all");
        classAll3.info();
    }
}
