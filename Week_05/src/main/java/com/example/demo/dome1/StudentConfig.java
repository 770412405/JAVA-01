package com.example.demo.dome1;

import com.example.demo.dome1.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 肖震
 * @date: 2021/2/21
 * @since:
 */
@Configuration
public class StudentConfig {
    @Bean("student3")
    public Student build_03() {
        return new Student(3, "Malone", "B");
    }
}
