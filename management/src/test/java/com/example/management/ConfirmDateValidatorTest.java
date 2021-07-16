package com.example.management;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.management.Validator.ConfirmDateValidator;
import com.example.management.form.UserAddForm;

@SpringBootTest
public class ConfirmDateValidatorTest {

	private ConfirmDateValidator validator = new ConfirmDateValidator();
	private ConstraintValidatorContext context;
	public UserAddForm userAddForm = new UserAddForm();

	@ParameterizedTest
	@ValueSource(strings = { "2020-10-09", "2020-10-11", "2020-1020" })
	void ConfirmDate(String s) {

		userAddForm.setRegistration_date("2020-10-10");
		userAddForm.setExpiration_date(s);
		assertTrue(validator.isValid(userAddForm, context));
	}

}
