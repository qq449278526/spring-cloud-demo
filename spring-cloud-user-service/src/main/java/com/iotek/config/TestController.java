package com.iotek.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 2018/7/4.
 */
@RefreshScope
@RestController
public class TestController {
    @Value("${from}")
    private String from;

    @GetMapping("/from")
    public String test(){
        return from;
    }
}
