package com.jgp.controller;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jgp.entity.Employee;
import com.jgp.entity.Employees;
import com.jgp.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class EmployeeController 
{
	@Autowired
    private EmployeeRepository employeeRepository;

	
	
	/* Otras Formas  pero Bajo jUnit Testing*/
	@GetMapping(path="/employees", produces = "application/json")
    public Employees getEmployees() 
    {
		Employees response = new Employees();
		ArrayList<Employee> list = new ArrayList<>();
		employeeRepository.findAll().forEach(e -> list.add(e));
		response.setEmployeeList(list);
        return response;
    }
    
    @PostMapping(path= "/employees", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {       
                
        //add resource
    	employee = employeeRepository.save(employee);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.getId())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
    
    
	/* Otras Formas  pero sin jUnit Testing*/   

	@GetMapping(path = "/getallemployee")
	public @ResponseBody Iterable<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@GetMapping(path = "/addemployee")
	public @ResponseBody String addNewEmployee(@RequestParam String ls_firstName, @RequestParam String ls_lastName, @RequestParam String ls_email) {
       employeeRepository.save(new Employee(ls_firstName,ls_lastName,ls_email));
		return "Saved";
	}

	@PostMapping(path = "/updatemployee")
	public @ResponseBody ResponseEntity<String> updateNewVehicle(@RequestBody Employee employe) {
		employeeRepository.save(employe);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PostMapping(path = "/removeemployee")
	public @ResponseBody ResponseEntity<String> removeVehicle(@RequestBody Employee employe) {
		employeeRepository.delete(employe);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	 @GetMapping(path = "/getemployeebyname")
	public @ResponseBody Iterable<Employee> getByName(@RequestParam String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

	@GetMapping(path = "/findByemployeenamecontaining")
	public @ResponseBody Iterable<Employee> findByNameContaining(@RequestParam String firstName) {
		return employeeRepository.findByFirstNameContaining(firstName);

	} 
    
    
    
    
    
}
