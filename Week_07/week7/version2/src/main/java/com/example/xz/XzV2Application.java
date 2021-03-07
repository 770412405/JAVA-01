package com.example.xz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.xz.v2")
public class XzV2Application {

    public static void main(String[] args) {
        SpringApplication.run(XzV2Application.class, args);
    }

}
