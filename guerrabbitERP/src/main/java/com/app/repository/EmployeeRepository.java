package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.app.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Long> 
{

}
