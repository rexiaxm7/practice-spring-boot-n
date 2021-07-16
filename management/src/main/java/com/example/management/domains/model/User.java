package com.example.management.domains.model;

import java.util.Date;

public class User {
	private int id;
	private String login_id;
	private String name;
	private String password;
	private String role;
	private int delete_flg;
	private Date expiration_date;
	private Date registration_date;

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getDelete_flg() {
		return delete_flg;
	}

	public void setDelete_flg(int delete_flg) {
		this.delete_flg = delete_flg;
	}

	public User(int id) {
		this.id = id;
	}

	public User(int id, String login_id, String name) {
		this.id = id;
		this.login_id = login_id;
		this.name = name;
	}

	public User(String login_id, String name, String password, String role, Date registration_date,
			Date expiration_date) {
		this.login_id = login_id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.registration_date = registration_date;
		this.expiration_date = expiration_date;
	}

	public User(int id, String login_id, String name, String password, String role, int delete_flg,
			Date registration_date, Date expiration_date) {
		this.login_id = login_id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.registration_date = registration_date;
		this.expiration_date = expiration_date;
	}

}