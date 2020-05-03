package com.task.service.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class CommandLineRunnerImpl implements CommandLineRunner {

	@Autowired
	private TaskService taskService;

	@Override
	public void run(String... args) throws Exception {
		if (args == null || args.length <= 0) {
			throw new Exception("No argument is found");
		}
//		if (taskService.checkDLNumber(args[1])) {
//			System.out.println("DL number is correct!");
//		} else {
//			System.out.println("DL number is incorrect!");
//		}
		for (String id : args) {
			taskService.printCustomer(Long.valueOf(id));
		}
	}
}
