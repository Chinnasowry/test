package com.example.TestExceptions.HomeRepo;


import org.springframework.data.repository.CrudRepository;

import com.example.TestExceptions.Model.Employee;

public interface EmpRepository extends CrudRepository	<Employee, Long> {
	
	Employee findByName(String empName);

}
