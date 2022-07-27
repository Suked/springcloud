package com.sut.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudProvideApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProvideApplication.class);
    }
}