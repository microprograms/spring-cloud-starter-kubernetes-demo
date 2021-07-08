package com.github.microprograms.spring_cloud_starter_kubernetes_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudStarterKubernetesDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStarterKubernetesDemoApplication.class, args);
	}

}
