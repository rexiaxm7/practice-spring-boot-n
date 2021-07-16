package com.example.management.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.management.Validator.ConfirmDateValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = { ConfirmDateValidator.class })
@Documented
public @interface ConfirmDate {

	String message() default "有効期限が不正です。";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
