package com.example.workdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 *@SpringBootApplication  标注是一个主程序类   说明这是一个springboot的程序   组合注解
 */
@SpringBootApplication
public class WorkdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkdemoApplication.class, args);

        System.out.println("启动成功了");
    }

}
