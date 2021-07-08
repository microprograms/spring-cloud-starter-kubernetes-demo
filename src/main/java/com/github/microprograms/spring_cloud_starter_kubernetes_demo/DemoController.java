package com.github.microprograms.spring_cloud_starter_kubernetes_demo;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoConfig demoConfig;

    @RequestMapping("/queryConfig")
    public String queryConfig() {
        return JSON.toJSONString(demoConfig);
    }
}
