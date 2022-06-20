package com.example.TestExceptions.HomeService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TestExceptions.HomeRepo.EmpRepository;
import com.example.TestExceptions.Model.Employee;
import com.example.TestExceptions.custmExce.EmptyException;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepository repo;

	public void dataSave(Employee emp) {
		if(emp.getName().isEmpty() || emp.getName().length()== 0)
		{
			throw new EmptyException("601", "Input feilds Empty Chinna");
		}
		repo.save(emp);		
	}
	
	
	
	public Employee findById(Long id) {
		
		return repo.findById(id).get();
				
	}



	public Employee dataGet(String empName) {
		
		return repo.findByName(empName);
	}




	


}
