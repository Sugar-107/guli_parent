package com.bilibili.cmsservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 程文辉
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.bilibili")
@MapperScan("com.bilibili.cmsservice.mapper")
@EnableDiscoveryClient
//@EnableFeignClients
public class CmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class,args);
    }
}
