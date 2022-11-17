package com.example.TestExceptions.HomeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestExceptions.HomeService.EmpService;
import com.example.TestExceptions.Model.Employee;

@RestController
@RequestMapping("/emp")
public class EmpController {


	@Autowired
	private EmpService empSer;

	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getData(@PathVariable("id") Long id ){

		return new ResponseEntity<Employee>(empSer.findById(id),HttpStatus.OK);			
	}
	
	@GetMapping("/getName/{empName}")
	public ResponseEntity<Employee> getDataName(@PathVariable("empName") String empName ){

		return new ResponseEntity<Employee>(empSer.dataGet(empName),HttpStatus.OK);	
		
	}
	
	@PostMapping
	public void saveData(@RequestBody Employee emp) {

		empSer.dataSave(emp);		
	}

	//git student1

}
