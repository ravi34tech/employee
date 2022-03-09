package com.ravi.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.employee.entity.Employee;
import com.ravi.employee.error.EmployeeException;
import com.ravi.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@PostMapping(path = "/employee")
	public ResponseEntity<String> save(@RequestBody Employee emp) throws EmployeeException {
		empService.save(emp);
		return new ResponseEntity<>("Successful Save with Id: "+emp.getId(), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/employee")
	public ResponseEntity<String> update(@RequestBody Employee emp) throws EmployeeException {
		empService.update(emp);
		return new ResponseEntity<>("Successful Save with Id: "+emp.getId(), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/employee/{id}")
	public Employee find(@PathVariable("id") Integer id) throws EmployeeException {
		return empService.find(id);
	}
	
	@DeleteMapping(path = "/employee/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws EmployeeException {
		empService.delete(id);
		return new ResponseEntity<>("Successful Delete with Id: "+id, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/employee")
	public List<Employee> findAll() throws EmployeeException {
		return empService.findAll();
	}
	
	@GetMapping(path = "/employee/name/{name}")
	public Employee searchByName(@PathVariable("name") String name) throws EmployeeException {
		return empService.findByName(name);
	}
	
}
