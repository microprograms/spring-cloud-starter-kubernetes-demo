package com.github.microprograms.spring_cloud_starter_kubernetes_demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.github.microprograms.spring_cloud_starter_kubernetes_demo.controller.MemoryController.MemoryStatistics.MemoryUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memory")
public class MemoryController {

    private List<String> grownList = new ArrayList<>();

    @RequestMapping("/grown")
    public String grown(String content, Integer repeat) {
        Map<String, Object> map = new HashMap<>();
        map.put("before", new MemoryStatistics(MemoryUnit.mb));
        if (null == content) {
            content = "这是一个字符串";
        }
        if (null == repeat) {
            repeat = 1;
        }
        for (int i = 0; i < repeat; i++) {
            grownList.add(_random(content));
        }
        map.put("after", new MemoryStatistics(MemoryUnit.mb));
        map.put("randomSampling", grownList.get(new Random().nextInt(grownList.size())));
        map.put("size", grownList.size());
        return JSON.toJSONString(map);
    }

    private static String _random(String content) {
        List<String> list = (content + content.hashCode() + new Random().nextLong()).chars().boxed().map(x -> {
            return Character.toString((char) x.intValue());
        }).collect(Collectors.toList());
        Collections.shuffle(list);
        return list.stream().collect(Collectors.joining());
    }

    public static class MemoryStatistics {
        private MemoryUnit memoryUnit;
        private long maxMemory; // 可以获得最大内存
        private long totalMemory; // 已分配到的内存大小
        private long freeMemory; // 所分配内存的剩余大小
        private long usableMemony; // 最大可用内存大小

        public MemoryStatistics() {
            this(MemoryUnit.bytes);
        }

        public MemoryStatistics(MemoryUnit memoryUnit) {
            this.memoryUnit = memoryUnit;
            int mb = 1024 * 1024;
            switch (memoryUnit) {
                case mb:
                    this.maxMemory = Runtime.getRuntime().maxMemory() / mb;
                    this.totalMemory = Runtime.getRuntime().totalMemory() / mb;
                    this.freeMemory = Runtime.getRuntime().freeMemory() / mb;
                    this.usableMemony = maxMemory - totalMemory + freeMemory;
                    break;

                default:
                    this.maxMemory = Runtime.getRuntime().maxMemory();
                    this.totalMemory = Runtime.getRuntime().totalMemory();
                    this.freeMemory = Runtime.getRuntime().freeMemory();
                    this.usableMemony = maxMemory - totalMemory + freeMemory;
                    break;
            }
        }

        public MemoryUnit getMemoryUnit() {
            return memoryUnit;
        }

        public long getMaxMemory() {
            return maxMemory;
        }

        public long getTotalMemory() {
            return totalMemory;
        }

        public long getFreeMemory() {
            return freeMemory;
        }

        public long getUsableMemony() {
            return usableMemony;
        }

        public static enum MemoryUnit {
            bytes, mb
        }
    }
}
