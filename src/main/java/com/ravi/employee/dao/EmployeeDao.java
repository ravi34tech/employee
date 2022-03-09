package com.ravi.employee.dao;

import java.util.List;

import com.ravi.employee.entity.Employee;
import com.ravi.employee.error.EmployeeException;

public interface EmployeeDao {

	void save(Employee emp) throws EmployeeException;

	Employee update(Employee emp) throws EmployeeException;

	Employee find(Integer id) throws EmployeeException;

	void delete(Integer id) throws EmployeeException;

	List<Employee> findAll() throws EmployeeException;

	List<Employee> findByIds(List<Integer> ids) throws EmployeeException;

	List<Employee> findByName(String name) throws EmployeeException;

}
