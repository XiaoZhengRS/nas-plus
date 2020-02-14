package com.xiaozhengkeji.nasplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard//开启Hysix监控服务
@SpringBootApplication
public class ServerHystrix {
    public static void main(String[] args) {
        SpringApplication.run(ServerHystrix.class, args);
    }
}
