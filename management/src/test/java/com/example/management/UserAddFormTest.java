package com.example.management;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.management.form.UserAddForm;

@SpringBootTest
public class UserAddFormTest {

	@Autowired
	Validator validator;

	public UserAddForm userAddForm = new UserAddForm();
	private BindingResult bindingResult = new BindException(userAddForm, "addForm");

	@ParameterizedTest
	@ValueSource(strings = { "aaaa", "",
			"aaaaaaaaaaaaaaaaaaaaa" })
	public void test_Name(String s) {
		userAddForm.setLogin_id("test10@crossware.co.jp");
		userAddForm.setPassword("bbb");
		userAddForm.setRole("ROLE_ADMIN");
		userAddForm.setRegistration_date("2020-10-09");
		userAddForm.setExpiration_date("2020-10-10");
		// テスト準備
		userAddForm.setName(s);
		// テスト実施
		validator.validate(userAddForm, bindingResult);
		// 結果検証
		assertThat(bindingResult.getFieldError());
	}

	@ParameterizedTest
	@ValueSource(strings = { "test10", "test11@crossware.co.jp", "" })
	public void test_Login_id(String s) {
		userAddForm.setName("aaa");
		userAddForm.setPassword("bbb");
		userAddForm.setRole("ROLE_ADMIN");
		userAddForm.setRegistration_date("2020-10-09");
		userAddForm.setExpiration_date("2020-10-10");
		// テスト準備
		userAddForm.setLogin_id(s);
		// テスト実施
		validator.validate(userAddForm, bindingResult);
		// 結果検証
		assertThat(bindingResult.getFieldError());
	}

	@ParameterizedTest
	@ValueSource(strings = { "aaaa", "", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" })
	public void test_Password(String s) {
		userAddForm.setName("aaa");
		userAddForm.setLogin_id("test10@crossware.co.jp");
		userAddForm.setRole("ROLE_ADMIN");
		userAddForm.setRegistration_date("2020-10-09");
		userAddForm.setExpiration_date("2020-10-10");
		// テスト準備
		userAddForm.setPassword(s);
		// テスト実施
		validator.validate(userAddForm, bindingResult);
		// 結果検証
		assertThat(bindingResult.getFieldError());
	}

	@ParameterizedTest
	@ValueSource(strings = { "ROLE_ADMIN", "", "ROLE_USER" })
	public void test_Role(String s) {
		userAddForm.setName("aaa");
		userAddForm.setLogin_id("test10@crossware.co.jp");
		userAddForm.setRole(s);
		userAddForm.setRegistration_date("2020-10-09");
		userAddForm.setExpiration_date("2020-10-10");
		// テスト準備
		userAddForm.setPassword("aaaa");
		// テスト実施
		validator.validate(userAddForm, bindingResult);
		// 結果検証
		assertThat(bindingResult.getFieldError());
	}

	@ParameterizedTest
	@ValueSource(strings = { "2020-10-09", "", "2020-10-11" })
	public void test_Registration_date(String s) {
		// テスト準備
		userAddForm.setName("aaa");
		userAddForm.setLogin_id("test10@crossware.co.jp");
		userAddForm.setPassword("bbb");
		userAddForm.setRole("ROLE_ADMIN");
		userAddForm.setExpiration_date("2020-10-10");
		userAddForm.setRegistration_date(s);
		// テスト実施
		validator.validate(userAddForm, bindingResult);
		// 結果検証
		assertThat(bindingResult.getFieldError());
	}

	@ParameterizedTest
	@ValueSource(strings = { "2020-10-09", "", "2020-10-11" })
	public void test_Expiration_date(String s) {
		// テスト準備
		userAddForm.setName("aaa");
		userAddForm.setLogin_id("test10@crossware.co.jp");
		userAddForm.setPassword("bbb");
		userAddForm.setRole("ROLE_ADMIN");
		userAddForm.setRegistration_date("2020-10-10");
		userAddForm.setExpiration_date(s);
		// テスト実施
		validator.validate(userAddForm, bindingResult);
		// 結果検証
		assertThat(bindingResult.getFieldError());
	}

}
