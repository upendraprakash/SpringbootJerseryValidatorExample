package com.javatechie.spring.rest.api.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.stereotype.Component;

import com.javatechie.spring.rest.api.exceptionmapper.EmployeExceptionMapper;
import com.javatechie.spring.rest.api.resource.EmployeeResource;
import com.javatechie.spring.rest.api.validator.DepartmentValidator;

@Component
public class RestConfig extends ResourceConfig{

	public RestConfig(Class<?>... classes) {
		packages("om.javatechie.spring.rest.api");
	    property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		register(EmployeeResource.class);
		register(DepartmentValidator.class);
		//register(EmployeExceptionMapper.class);
	}
	

}
