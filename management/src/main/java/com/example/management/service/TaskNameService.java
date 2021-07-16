package com.example.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.domains.model.Task;
import com.example.management.form.AddForm;
import com.example.management.mappers.TaskMapper;

@Service
public class TaskNameService {

	@Autowired
	TaskMapper TaskMapper;

	@Transactional(propagation = Propagation.REQUIRED)
	public void addTest() {
		insertTest();
	}

	private void addTaskName(AddForm addForm) {
		Task task = new Task(addForm.getName());
		TaskMapper.addName(task);
	}

	private void insertTest() {

		TaskMapper.testInsert2();
	}

}
