package com.task.service.demo.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({ "classpath:customer-db.properties" })
@EnableJpaRepositories(basePackages = "com.task.service.job", entityManagerFactoryRef = "customerEntityManager", transactionManagerRef = "customerTransactionManager")
public class CustomerConfig {

	@Autowired
	private Environment environment;

	@Bean
	public LocalContainerEntityManagerFactoryBean customerEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(customerDataSource());
		em.setPackagesToScan(new String[] { "com.task.service.job" });
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		properties.put("hibernate.dialect.storage_engine", environment.getProperty("hibernate.dialect.storage_engine"));
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Bean
	public DataSource customerDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("customer.datasource.driverClassName"));
		dataSource.setUrl(environment.getProperty("customer.datasource.url"));
		dataSource.setUsername(environment.getProperty("customer.datasource.username"));
		dataSource.setPassword(environment.getProperty("customer.datasource.password"));
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager customerTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(customerEntityManager().getObject());
		return transactionManager;
	}
}
