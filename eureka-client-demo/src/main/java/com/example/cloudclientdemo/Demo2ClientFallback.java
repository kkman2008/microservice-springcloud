package com.example.cloudclientdemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class Demo2ClientFallback implements Demo2Client{

    @Override
    public String getUsername(){
        return "feign fallback";
    }

}
