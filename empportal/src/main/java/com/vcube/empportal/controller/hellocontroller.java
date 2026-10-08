package com.vcube.empportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.empportal.model.Employee12;
import com.vcube.empportal.repo.employeerepo;

@CrossOrigin()
@RestController
public class hellocontroller {
	@Autowired
	 employeerepo employeeRepo;
	 
	@GetMapping("/hello")
	String hello() {
		return "springboot is comedy!!";
	}
	
	@GetMapping("/getAllEmployeeDetails")
	List<Employee12> getAllEmployeeDetails(){
		return employeeRepo.findAll();
		
	}
	@GetMapping("/get/Employee12/{eid}")
	Employee12 getemployee(@PathVariable Integer eid) {
		return employeeRepo.findById(eid).orElseThrow();
	}
	
	@PostMapping("/createemployeelist")
	Employee12 createEmployee(@RequestBody Employee12 employee) {
		return employeeRepo.save(employee);
	}
	
	@PutMapping("/updateEmployee12/{eid}")
	Employee12 updateemployee(@RequestBody Employee12 employee, @PathVariable Integer eid){
		
		Employee12 empFromDb = getEmployee12(eid);
		
		if (empFromDb == null) {
	        return null; // better: return 404
	    }
		
		empFromDb.setCity(employee.getCity());
		empFromDb.setEname(employee.getEname());
		empFromDb.setSalary(employee.getSalary());
		empFromDb.setState(employee.getState());
		return employeeRepo.save(empFromDb);

	}
	
	
	

	private Employee12 getEmployee12(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("/delEmployee12/{eid}")
	String deleteemployee(@PathVariable Integer eid) {
		employeeRepo.deleteById(eid);
		return "employee is deleted succesfully of eid!!" +eid; 
	}
}
