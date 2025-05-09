package com.example.xm.graduate_project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GraduateProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(GraduateProjectApplication.class, args);
    }

}
