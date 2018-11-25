package com.fh.product.producer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.fh.product.producer.mapper")
@EnableDiscoveryClient
@EnableFeignClients("com.fh.brand.api")
public class ProductProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductProducerApplication.class, args);
    }
}
