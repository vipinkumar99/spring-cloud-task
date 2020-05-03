package com.task.service.demo.service;

import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.stereotype.Component;

@Component
public class TaskExecutionListenerImpl implements TaskExecutionListener {

	@Override
	public void onTaskStartup(TaskExecution taskExecution) {
		System.out.println("Task is starting !");
	}

	@Override
	public void onTaskEnd(TaskExecution taskExecution) {
		taskExecution.setExitMessage("DONE");
		System.out.println("Task is ending !");
	}

	@Override
	public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
		System.out.println("Task : " + taskExecution.getTaskName() + " Exception : " + throwable.getMessage());
	}

}
