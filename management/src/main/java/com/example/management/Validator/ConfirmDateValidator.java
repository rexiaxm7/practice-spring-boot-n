package com.example.management.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.management.annotation.ConfirmDate;
import com.example.management.form.UserAddForm;

public class ConfirmDateValidator implements ConstraintValidator<ConfirmDate, UserAddForm> {

	@Override
	public boolean isValid(UserAddForm value, ConstraintValidatorContext context) {
		if (value.getExpiration_date().isEmpty() || value.getRegistration_date().isEmpty()) {
			return false;
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date expiration_date = null;
		Date registration_date = null;
		try {
			expiration_date = dateFormat.parse(value.getExpiration_date());
			registration_date = dateFormat.parse(value.getRegistration_date());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return expiration_date.after(registration_date) ? true : false;
	}

}
