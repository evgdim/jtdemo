package com.nevexis.jtdemo.drivers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by evgeni on 10/3/2016.
 */
@RefreshScope
@RestController
@RequestMapping("/custom")
public class CustomController {
    private String messageFromConfig;
    private DiscoveryClient discoveryClient;
    
    public CustomController(@Value("${drivers.message}") String messageFromConfig, @Autowired DiscoveryClient discoveryClient) {
        this.messageFromConfig = messageFromConfig;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/message")
    public String mssage(){
        return this.messageFromConfig;
    }
    
    @GetMapping("/services/{appName}")
    public List<ServiceInstance> services(@PathVariable("appName") String appName){ 
    	return this.discoveryClient.getInstances(appName);
    }
}
