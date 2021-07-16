package com.example.management.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.details.AccountDetails;
import com.example.management.domains.model.Account;
import com.example.management.domains.model.Task;
import com.example.management.form.AddForm;
import com.example.management.mappers.TaskMapper;
import com.example.management.repository.AccountRepository;
import com.example.management.repository.TaskRepository;

@Service
public class AddTaskService {

	@Autowired
	TaskMapper TaskMapper;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	TaskNameService taskNameService;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addTest(AccountDetails accountDetails, AddForm addForm) {
		addTask(accountDetails, addForm);
	}

	private void addTask(AccountDetails accountDetails, AddForm addForm) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date deadline = null;
		try {
			deadline = dateFormat.parse(addForm.getDeadline());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String userId = accountDetails.getUsername();
		Account account = accountRepository.findById(userId);
		int user_id = account.getId();
		Task task = new Task(user_id, addForm.getName(), deadline);
		TaskMapper.add(task);
	}

}
