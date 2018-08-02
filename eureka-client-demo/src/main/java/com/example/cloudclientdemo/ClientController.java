package com.example.cloudclientdemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Demo2Client demo2Client;

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return discoveryClient.getInstances("eureka-server-1");
    }

    //------------接口------

    @HystrixCommand(fallbackMethod = "getUsernameFallback")
    @GetMapping("/username")
    public Object getUsername() {
        return restTemplate.getForObject("http://EUREKA-CLIENT-2/username", String.class);
    }

    public Object getUsernameFallback() {
        return "fall back";
    }


    /**
     * 使用Feign远程访问生产者
     * @return
     */
    @GetMapping("/usernameByFeign")
    public Object getUsernameByFeign(){
        return demo2Client.getUsername();
    }

}
