package com.example.cloudclientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return discoveryClient.getInstances("eureka-server-1");
    }


    //------------接口-------

    @GetMapping("/username")
    public Object getUsername() {
//        if(1 == 1)
//            throw new RuntimeException("报错了！！！");
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client-2");
        System.out.println("选用的接口：：" + serviceInstance.getPort());
        return "this is client2 interface-->client-demo2, 负载均衡选的是端口号：" + serviceInstance.getPort() ;
    }

}
