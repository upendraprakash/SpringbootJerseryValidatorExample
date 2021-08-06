package com.javatechie.spring.rest.api.exceptionmapper;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class EmployeExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
	 @Override
	    public Response toResponse(ConstraintViolationException exception) {
	        return Response.status(Response.Status.BAD_REQUEST)
	            .entity(prepareMessage(exception))
	            .type("text/plain")
	            .build();
	    }

	    private String prepareMessage(ConstraintViolationException exception) {
	        StringBuilder message = new StringBuilder();
	        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
	            message.append(cv.getPropertyPath() + " " + cv.getMessage() + "\n");
	        }
	        return message.toString();
	    }
}
