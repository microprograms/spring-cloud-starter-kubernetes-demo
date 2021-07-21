package com.github.microprograms.spring_cloud_starter_kubernetes_demo.controller;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpu")
public class CpuController {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @RequestMapping("/startCalc")
    public String startCalc() {
        try {
            executorService.execute(() -> {
                while (!Thread.interrupted()) {
                    while (true) {
                        Math.pow(Math.PI, new Random().nextDouble());
                    }
                }
            });
            return "success";
        } catch (RejectedExecutionException e) {
            return "already started";
        }
    }

    @RequestMapping("/stopCalc")
    public String stopCalc() {
        executorService.shutdownNow();
        return "shutdown now";
    }

}
