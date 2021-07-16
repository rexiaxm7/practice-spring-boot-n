package com.example.management.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserUpdateForm {

	private String id;
	@Size(max = 100, message = "名前は20文字以内で入力してください")
	@NotBlank(message = "名前を入力してください")
	private String name;
	@Size(max = 100, message = "メールアドレスは100文字以内で入力してください")
	@NotBlank(message = "メールアドレスを入力してください")
	@Email
	private String login_id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

}