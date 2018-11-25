package com.fh.shop.protal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShopProtalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopProtalApplication.class, args);
    }
}
