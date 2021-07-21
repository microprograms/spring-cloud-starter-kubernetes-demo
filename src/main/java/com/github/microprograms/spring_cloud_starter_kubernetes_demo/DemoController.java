package com.github.microprograms.spring_cloud_starter_kubernetes_demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.github.microprograms.spring_cloud_starter_kubernetes_demo.MemoryStatistics.MemoryUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoConfig demoConfig;

    private List<String> memoryGrown = new ArrayList<>();

    @RequestMapping("/queryConfig")
    public String queryConfig() {
        return JSON.toJSONString(demoConfig);
    }

    @RequestMapping("/memoryGrown")
    public String memoryGrown(String content, Integer repeat) {
        Map<String, Object> map = new HashMap<>();
        map.put("before", new MemoryStatistics(MemoryUnit.mb));
        if (null == content) {
            content = "这是一个字符串";
        }
        if (null == repeat) {
            repeat = 1;
        }
        for (int i = 0; i < repeat; i++) {
            memoryGrown.add(_random(content));
        }
        map.put("after", new MemoryStatistics(MemoryUnit.mb));
        map.put("randomSampling", memoryGrown.get(new Random().nextInt(memoryGrown.size())));
        map.put("size", memoryGrown.size());
        return JSON.toJSONString(map);
    }

    private static String _random(String content) {
        List<String> list = (content + content.hashCode() + new Random().nextLong()).chars().boxed().map(x -> {
            return Character.toString((char) x.intValue());
        }).collect(Collectors.toList());
        Collections.shuffle(list);
        return list.stream().collect(Collectors.joining());
    }
}
