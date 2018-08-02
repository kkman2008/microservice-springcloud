package com.example.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestDemoController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 系统A-生产者
     * 对外暴露服务接口
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public Object getUserName(@PathVariable long id) {
        System.out.println("系统A的接口--------" + id);
        return "this is name " + id;
    }


    /**
     * 系统B-消费者
     * 远程调用系统A的接口
     * @return
     */
    @GetMapping("/call")
    public Object restCall () {
        long id= 1L;
        String username = restTemplate.getForObject("http://localhost:8080/user/" + id , String.class);
        System.out.println("远程调用结果-------------->" + username);
        return username;
    }


}
