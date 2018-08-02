package com.example.cloudclientdemo;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class Demo2ClientFallbackFactory implements FallbackFactory<Demo2Client> {

    public Demo2Client create(Throwable cause) {

        return new Demo2Client() {
            @Override
            public String getUsername() {

                System.out.println(cause.toString());

                return "hello world fallbackfactory";
            }
        };

    }
}
