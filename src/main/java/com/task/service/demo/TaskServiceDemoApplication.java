package com.task.service.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@EnableTask
@SpringBootApplication
public class TaskServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskServiceDemoApplication.class, args);
	}

	
}
