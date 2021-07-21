package com.github.microprograms.spring_cloud_starter_kubernetes_demo.controller;

import com.alibaba.fastjson.JSON;
import com.github.microprograms.spring_cloud_starter_kubernetes_demo.config.DemoConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private DemoConfig demoConfig;

    @RequestMapping("/query")
    public String queryConfig() {
        return JSON.toJSONString(demoConfig);
    }
}
