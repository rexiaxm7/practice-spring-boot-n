package com.example.management.form;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.management.annotation.ConfirmDate;

@ConfirmDate
public class UserAddForm {
	
	@Size(max = 20, message = "名前は20文字以内で入力してください")
	@NotBlank(message = "名前を入力してください")
	private String name;
	
	@Size(max = 100, message = "メールアドレスは100文字以内で入力してください")
	@NotBlank(message = "メールアドレスを入力してください")
	@Email
	private String login_id;
	
	@Size(max = 100, message = "パスワードは100文字以内で入力してください")
	@NotBlank(message = "パスワードを入力してください")
	private String password;
	
	@NotBlank(message = "権限を入力してください")
	private String role;
	
	@NotBlank(message = "登録日を入力してください")
	public String registration_date;
	
	@NotBlank(message = "有効期限を入力してください")
	public String expiration_date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
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
	
	public String getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	
}
