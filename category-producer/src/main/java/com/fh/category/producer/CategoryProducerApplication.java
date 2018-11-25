package com.fh.category.producer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.fh.category.producer.mapper")
@EnableDiscoveryClient
public class CategoryProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoryProducerApplication.class, args);
    }
}
