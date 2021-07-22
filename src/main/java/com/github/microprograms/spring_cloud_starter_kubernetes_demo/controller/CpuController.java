package com.github.microprograms.spring_cloud_starter_kubernetes_demo.controller;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpu")
public class CpuController {
    private static final Logger log = LoggerFactory.getLogger(CpuController.class);

    private ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
            new SynchronousQueue<Runnable>()); // 容量为1的线程池

    @RequestMapping("/startCalc")
    public String startCalc() {
        try {
            executorService.submit(() -> {
                while (!Thread.interrupted()) {
                    while (true) {
                        log.info("result={}", Math.pow(Math.PI, new Random().nextDouble()));
                    }
                }
                log.info("interrupted");
            });
            log.info("startCalc");
            return "success";
        } catch (RejectedExecutionException e) {
            log.info("already started");
            return "already started";
        }
    }

    @RequestMapping("/stopCalc")
    public String stopCalc() {
        executorService.shutdownNow();
        log.info("stopCalc");
        return "success";
    }

}
