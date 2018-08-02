package com.example.cloudclientdemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "eureka-client-2", fallback = Demo2ClientFallback.class)
@FeignClient(name = "eureka-client-2", fallbackFactory = Demo2ClientFallbackFactory.class)
public interface Demo2Client {

    @GetMapping("/username")
    public String getUsername();



}
