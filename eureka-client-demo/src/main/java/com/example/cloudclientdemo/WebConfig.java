package com.example.cloudclientdemo;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
public class WebConfig {

    @Bean
    //为RestTemplate整合Ribbon的负载均衡能力
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
