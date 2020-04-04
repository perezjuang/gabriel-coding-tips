package com.jgp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jgp.entity.Employee;
import java.util.List;
@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Long> 
{
	 List<Employee> findByFirstName(String firstName);

	 List<Employee> findByFirstNameContaining(String firstName);
}
