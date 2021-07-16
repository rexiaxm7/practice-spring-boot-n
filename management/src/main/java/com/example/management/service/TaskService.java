package com.example.management.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.Entity.TaskEntity;
import com.example.management.details.AccountDetails;
import com.example.management.domains.model.Account;
import com.example.management.domains.model.Task;
import com.example.management.form.AddForm;
import com.example.management.form.UpdateForm;
import com.example.management.mappers.TaskMapper;
import com.example.management.repository.AccountRepository;
import com.example.management.repository.TaskRepository;

@Service
public class TaskService {
	
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
	TaskNameService taskNameService;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addTest(AccountDetails accountDetails,AddForm addForm) {
		insertTest();
		
		addTaskService.addTest(accountDetails,addForm);
		taskNameService.addTest();
	}
	
	public Page<TaskEntity> findList(String userId,Pageable pageable){
		Account account = accountRepository.findById(userId);
		int user_id = account.getId();
        return taskRepository.findByUserId(user_id, pageable);
    }
	
	public void doneTask(String userId) {
		Task Task = new Task(Integer.parseInt(userId));	
		TaskMapper.done(Task);
	}
	
	public void deleteTask(String userId){
		Task Task = new Task(Integer.parseInt(userId));
		TaskMapper.delete(Task);
	}
	
	public Task findOne(String userId){
		Task Task = new Task(Integer.parseInt(userId));
		return TaskMapper.findById(Task);
	}
	
	public void updateTask(UpdateForm updateForm){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date deadline = null;
		try {
			deadline = dateFormat.parse(updateForm.getDeadline());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Task task = new Task(Integer.parseInt(updateForm.getId()),updateForm.getName(), deadline,updateForm.getVersion());
		TaskMapper.update(task);
		
		throw new RuntimeException();
    }
	
	private void insertTest(){
		
		TaskMapper.testInsert();
	}
	
}
