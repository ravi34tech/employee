package com.ravi.employee.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.ravi.employee.dao.EmployeeDao;
import com.ravi.employee.entity.Employee;
import com.ravi.employee.error.EmployeeException;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	
	private static List<Employee> listOfEmp = new ArrayList<>();
	private static Integer maxCount = 50;
	
	static {
	  IntStream.rangeClosed(0, maxCount).forEach(count -> {
		  Employee emp = new Employee();
		  emp.setId(count);
		  emp.setName("Emp_"+count);
		  emp.setAddress("City_"+count);
		  emp.setMobile(Integer.toString(98982345+count));
		  emp.setEmail("testmail_"+count+"@gamil.com");
		  listOfEmp.add(emp);
	  });	
	  System.out.println(" ------------>  Static data is prepared successfully .......");
	}

	@Override
	public void save(Employee emp) throws EmployeeException {
		emp.setId(null);
		emp.setId(maxCount++);
		listOfEmp.add(emp);
	}

	@Override
	public Employee update(Employee emp) throws EmployeeException {
		delete(emp.getId());
		listOfEmp.add(emp);
		return emp;
	}

	@Override
	public Employee find(Integer id) throws EmployeeException {
		return listOfEmp.stream()
				.filter(emp -> emp.getId().equals(id))
				.findFirst()
				.orElseThrow();
	}

	@Override
	public void delete(Integer id) throws EmployeeException {
		Employee empDelete = find(id);
		if(empDelete == null) {
			throw new EmployeeException("Record is not found with id: "+id);
		}
		listOfEmp.remove(empDelete);
	}

	@Override
	public List<Employee> findAll() throws EmployeeException {
		return listOfEmp;
	}

	@Override
	public List<Employee> findByIds(List<Integer> ids) throws EmployeeException {
		return listOfEmp.stream()
				.filter(emp -> ids.contains(emp.getId()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Employee> findByName(String name) throws EmployeeException {
		return listOfEmp.stream()
				.filter(emp -> name.equalsIgnoreCase(emp.getName()))
				.collect(Collectors.toList());
	}

}
