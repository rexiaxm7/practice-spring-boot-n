package com.example.management.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateForm {

	private String id;
	@Size(max = 100, message = "タイトルは100桁以内で入力してください")
	@NotBlank(message = "名前を入力してください")
	private String name;
	@NotBlank(message = "期限を入力してください")
	private String deadline;
	private int version;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}