package com.example.management.domains.model;

import java.util.Date;

public class Task {

	private int id;
	private int user_id;
	private String name;
	private int status;
	private Date deadline;
	private int version;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUser_Id(int user_id) {
		this.id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Task(int id) {
		this.id = id;
	}

	public Task(String name) {
		this.name = name;
	}

	public Task(int id, int user_id, String name, int status, Date deadline, int version) {
		this.id = id;
		this.user_id = user_id;
		this.name = name;
		this.status = status;
		this.deadline = deadline;
		this.version = version;
	}

	public Task(int id, String name, Date deadline, int version) {
		this.id = id;
		this.name = name;
		this.deadline = deadline;
		this.version = version;
	}

	public Task(int user_id, String name, Date deadline) {
		this.user_id = user_id;
		this.name = name;
		this.deadline = deadline;
	}

	public Task(String name, Date deadline) {
		this.name = name;
		this.deadline = deadline;
	}
}
