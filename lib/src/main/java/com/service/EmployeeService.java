package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService {
	
//  this method will save every employee object into DB
//  once the object successfully stored, then it returns boolean
	
	public boolean addEmployee(Employee e);
	public List<Employee> getAllEmployee();
	public int deleteEmployeeById(int empId);
	public Employee getEmployeeById(int empId);
	public int updateEmployeeById(int empId);

}
