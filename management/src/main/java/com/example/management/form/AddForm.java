package com.example.management.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddForm {

	@Size(max = 100, message = "タイトルは100桁以内で入力してください")
	@NotBlank(message = "名前を入力してください")
	private String name;
	@NotBlank(message = "期限を入力してください")
	public String deadline;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
}
