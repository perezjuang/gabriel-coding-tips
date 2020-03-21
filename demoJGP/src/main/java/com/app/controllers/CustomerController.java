package com.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.models.*;
import com.app.repository.CustomerRepository;


@Controller   
@RequestMapping(path="/pos") 
public class CustomerController {
	@Autowired 
	private CustomerRepository CustomerRepository;

	
	@GetMapping(path="/getallcustomer")
	public @ResponseBody Iterable<Customer> getAllCustomer() {
		// This returns a JSON or XML with the users
		return CustomerRepository.findAll();
		
	}
	
	
	
	@GetMapping(path="/addcustomer") // Map ONLY GET Requests
	public @ResponseBody String addNewCustomer (
			@RequestParam String customer_id,
			@RequestParam String name) {

		CustomerRepository.save(new 
				Customer(customer_id, name));
		
		return "Saved";
	}
	
	
	@PostMapping(path="/updatecustomer") 
	public @ResponseBody ResponseEntity<String> updateNewCustomer (
			@RequestBody Customer customer) {
		CustomerRepository.save(customer);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping(path="/removecustomer") 
	public @ResponseBody ResponseEntity<String> removeCustomer (
			@RequestBody Customer customer) {
		CustomerRepository.delete(customer);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	


	
	@GetMapping(path="/getbyname")
	public @ResponseBody Iterable<Customer> getByName(
			@RequestParam String name
			) {
		return CustomerRepository.findByName(name);		
	}
	
	

	
	
	@GetMapping(path="/findByNameContaining")
	public @ResponseBody Iterable<Customer> findByNameContaining(
			@RequestParam String name
			) {
		return CustomerRepository.findByNameContaining(name);
			
	}
	

	
	
	
	
	
}
