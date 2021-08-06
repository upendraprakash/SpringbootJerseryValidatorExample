package com.javatechie.spring.rest.api.validator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=DepartmentValidator.class)
public @interface DEPARTMENT {
	String message()

    default "Department  is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
