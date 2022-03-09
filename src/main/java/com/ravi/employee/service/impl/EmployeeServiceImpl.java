package com.ravi.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.employee.dao.EmployeeDao;
import com.ravi.employee.entity.Employee;
import com.ravi.employee.error.EmployeeException;
import com.ravi.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public void save(Employee emp) throws EmployeeException {
		if(emp == null) {
			throw new EmployeeException("Request body is empty, InvalidRequest");
		}
		emp.setId(null);
		employeeDao.save(emp);
	}

	@Override
	public Employee update(Employee emp) throws EmployeeException {
		if(emp == null) {
			throw new EmployeeException("Request body is empty, InvalidRequest");
		}
		
		if(emp.getId() == null) {
			throw new EmployeeException("InvalidRequest for updation. Employee record is not found, id is empty");
		}
		return employeeDao.update(emp);
	}

	@Override
	public Employee find(Integer id) throws EmployeeException {
		return employeeDao.find(id);
	}

	@Override
	public void delete(Integer id) throws EmployeeException {
		employeeDao.delete(id);
	}

	@Override
	public List<Employee> findAll() throws EmployeeException {
		return employeeDao.findAll();
	}

	@Override
	public List<Employee> findByIds(List<Integer> ids) throws EmployeeException {
		return employeeDao.findByIds(ids);
	}

	@Override
	public Employee findByName(String name) throws EmployeeException {
		List<Employee> empList = employeeDao.findByName(name);
		return empList.get(0);
	}

}
