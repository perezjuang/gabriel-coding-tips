package com.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.entity.Employees;
import com.app.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/employ")

public class EmployeeController 
{
	@Autowired
    private EmployeeRepository employeeRepository;

    //***Api Final Front
    @PostMapping(path= "/addemployee", consumes = "application/json", produces = "application/json")
	public Employee addNewEmployeeApi(@RequestBody Employee employee) {
        //add resource
     	employee = employeeRepository.save(employee);
		return employee;
	}
    
    //***Api Final Para FRONT
    @GetMapping(path= "/employeegetall", produces = "application/json")
    public Employees getAllEmployeesApi() 
    {
		Employees response = new Employees();
		ArrayList<Employee> list = new ArrayList<>();
		employeeRepository.findAll().forEach(e -> list.add(e));
		response.setEmployeeList(list);
        return response;
    }
       
    //***Api Final Front
    @PostMapping(path= "/updateemployee", consumes = "application/json", produces = "application/json")
	public Employee saveEmployeeApi(@RequestBody Employee employee) {
        //add resource
     	employeeRepository.save(employee);
		return employee;
	}
    //***Api Final Front
	@PostMapping(path = "/employeeremove", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> deleteEmployeeApi(@RequestBody Employee employe) {
		employeeRepository.delete(employe);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
    
    
    
    
    
	  
    
}
