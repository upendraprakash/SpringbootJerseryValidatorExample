package com.javatechie.spring.rest.api.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javatechie.spring.rest.api.model.Employee;

public class DepartmentValidator implements ConstraintValidator<DEPARTMENT, Employee>{
	String dept[]= {"ENG","HR","ACC"};
	List<String> DEPT=(List<String>) Arrays.asList(dept);

	 @Override
	    public void initialize(DEPARTMENT department) {
	    }

	@Override
	public boolean isValid(Employee value, ConstraintValidatorContext context) {
		return DEPT.contains(value.getDept());
	}
	 

}
