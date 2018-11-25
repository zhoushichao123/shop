package com.fh.shop.brand.producer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan("com.fh.shop.brand.producer.mapper")
@EnableDiscoveryClient
public class BrandProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrandProducerApplication.class, args);
    }
}
