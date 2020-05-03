package com.task.service.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;
import org.springframework.stereotype.Component;

@Component
public class CustomTaskConfigurer extends DefaultTaskConfigurer {

	@Autowired
	public CustomTaskConfigurer(@Qualifier("taskDataSource")DataSource dataSource) {
		super(dataSource);
	}

}
