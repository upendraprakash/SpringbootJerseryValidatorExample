package com.javatechie.spring.rest.api.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.javatechie.spring.rest.api.dao.EmployeeDao;
import com.javatechie.spring.rest.api.model.Employee;
import com.javatechie.spring.rest.api.validator.DEPARTMENT;

import lombok.val;

@Path("/employeeResource")
public class EmployeeResource {
	
	@Autowired
	private EmployeeDao dao;
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@Path("/save")
	public Employee saveEmployee(@Valid @DEPARTMENT @RequestBody Employee employee) {
		return dao.save(employee);
	}
	
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/getAllEmployees")
	public List<Employee> getAllEMployees(){
		return dao.findAll();	
	}
	
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/getEmployee/{name}")
	public Employee getEmployeeByName(@Valid @NotEmpty(message="Name mus be present") @PathParam("name") String name) {
		return dao.findByName(name);
	}

//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleValidationExceptions(
//	  MethodArgumentNotValidException ex) {
//	    Map<String, String> errors = new HashMap<>();
//	    ex.getBindingResult().getAllErrors().forEach((error) -> {
//	        String fieldName = ((FieldError) error).getField();
//	        String errorMessage = error.getDefaultMessage();
//	        errors.put(fieldName, errorMessage);
//	    });
//	    return errors;
//	}
}
