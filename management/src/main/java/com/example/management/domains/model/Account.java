package com.example.management.domains.model;

import lombok.Data;
 
@Data
public class Account {
	private int id;
	private String login_id;
	private String name;
	private String password;
	private String role;
	private int delete_flg;
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
	
	
}