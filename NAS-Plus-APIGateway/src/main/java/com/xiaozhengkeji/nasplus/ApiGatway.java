package com.xiaozhengkeji.nasplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient //标识 是一个Eureka客户端
@SpringBootApplication
public class ApiGatway {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatway.class, args);
    }
}
