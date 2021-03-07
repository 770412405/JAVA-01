package com.example.xz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.xz.mapper")
public class XzApplication {

    public static void main(String[] args) {
        SpringApplication.run(XzApplication.class, args);
    }

}
