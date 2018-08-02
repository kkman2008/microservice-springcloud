package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulDemoApplication {

    @Bean
    PreLogFilter preLogFilter() {
        return new PreLogFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulDemoApplication.class, args);
    }
}
