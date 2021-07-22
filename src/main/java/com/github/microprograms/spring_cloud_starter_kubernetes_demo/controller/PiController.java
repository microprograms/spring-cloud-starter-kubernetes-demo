package com.github.microprograms.spring_cloud_starter_kubernetes_demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.alibaba.fastjson.JSON;
import com.github.microprograms.spring_cloud_starter_kubernetes_demo.utils.Pi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pi")
public class PiController {
    private ExecutorService executorService = Executors.newCachedThreadPool();

    @RequestMapping("/gridPi")
    public String gridPi() {
        Map<String, Object> map = new HashMap<>();
        map.put("start", System.currentTimeMillis());
        map.put("pi", Pi.grid_pi(Integer.MAX_VALUE));
        map.put("end", System.currentTimeMillis());
        map.put("cost", (long) map.get("end") - (long) map.get("start"));
        return JSON.toJSONString(map);
    }

    @RequestMapping("/startCalc")
    public String startCalc(Integer repeat) {
        if (null == repeat) {
            repeat = 1;
        }
        for (int i = 0; i < repeat; i++) {
            executorService.submit(() -> {
                return Pi.grid_pi(Integer.MAX_VALUE);
            });
        }
        return "success";
    }

    @RequestMapping("/stopCalc")
    public String stopCalc() {
        executorService.shutdownNow();
        return "shutdown now";
    }

}
