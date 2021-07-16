package com.example.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.details.AccountDetails;
import com.example.management.form.AddForm;
import com.example.management.mappers.TaskMapper;
import com.example.management.repository.AccountRepository;
import com.example.management.repository.TaskRepository;

@Service
public class TaskService2 {

	@Autowired
	TaskMapper TaskMapper;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	AddTaskService addTaskService;

	@Autowired
	TaskNumService taskNumService;

	@Autowired
	TaskService taskService;

	@Transactional(propagation = Propagation.REQUIRED)
	public void addTest(AccountDetails accountDetails, AddForm addForm) {
		taskService.addTest(accountDetails, addForm);
		taskNumService.addTest(addForm);
		throw new RuntimeException();
	}

}
