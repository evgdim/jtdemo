package com.nevexis.jtdemo.drivers.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
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

    public CustomController(@Value("${drivers.message}") String messageFromConfig) {
        this.messageFromConfig = messageFromConfig;
    }

    @GetMapping("/message")
    public String mssage(){
        return this.messageFromConfig;
    }
}
