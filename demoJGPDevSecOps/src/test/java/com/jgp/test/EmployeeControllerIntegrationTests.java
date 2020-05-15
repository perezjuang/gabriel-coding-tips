package com.jgp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.jgp.SpringBootDemoApplication;
import com.jgp.entity.Employee;
import com.jgp.entity.Employees;

@SpringBootTest(classes = SpringBootDemoApplication.class, 
		webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTests 
{
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Sql({ "classpath:schema.sql", "classpath:data.sql" })
	@Test
	public void testAllEmployees() 
	{
		
		assertTrue(
				this.restTemplate
					.getForObject("http://localhost:" + port + "/employeeAPI/employees", Employees.class)
					.getEmployeeList().size() == 3);
	}

	@Test
	public void testAddEmployee() {
		Employee employee = new Employee(0,"Lokesh", "Gupta", "howtodoinjava@gmail.com");
		
		ResponseEntity<String> responseEntity = this.restTemplate
			.postForEntity("http://localhost:" + port + "/employeeAPI/employees", employee, String.class);

		assertEquals(201, responseEntity.getStatusCodeValue());
	}
	
	
}
