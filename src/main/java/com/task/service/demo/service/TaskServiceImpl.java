package com.task.service.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.service.job.Customer;
import com.task.service.job.CustomerRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean checkDLNumber(String dlNumber) {
		return dlNumber.equals("12345");
	}

	@Override
	public boolean printCustomer(Long id) {
		if (id == null) {
			return false;
		}
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isPresent()) {
			System.out.println(optional.get().toString());
			return true;
		}
		return false;
	}
}
