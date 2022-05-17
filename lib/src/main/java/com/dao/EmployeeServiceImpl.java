package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import com.model.Employee;
import com.service.EmployeeService;
import com.utility.EmployeeUtility;

public class EmployeeServiceImpl implements EmployeeService {

// Service class implementing all the abstract method.

	public boolean addEmployee(Employee e) {
//  we have to establish the connection between java and jdbc

		int status = 0;
		try {
			Connection con = EmployeeUtility.getConnect();
			final String INSERT_EMP = "insert into Employee_Table values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(INSERT_EMP);
			ps.setInt(1, e.getEmpId());
			ps.setString(2, e.getEmpName());
			ps.setDouble(3, e.getEmpSalary());
			ps.setLong(4, e.getEmpPhone());

			status = ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		if (status == 1) {
			return true;
		}
		return false;
	}

	public List<Employee> getAllEmployee() {

		List<Employee> listOfEmp = new ArrayList<Employee>();
		try {
			Connection con = EmployeeUtility.getConnect();
			PreparedStatement ps = con.prepareStatement("select * from Employee_Table");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("empId");
				String name = rs.getString("empName");
				double salary = rs.getDouble("salary");
				long phone = rs.getLong(4);
				Employee e = new Employee();
				e.setEmpId(id);
				e.setEmpName(name);
				e.setEmpSalary(salary);
				e.setEmpPhone(phone);
				listOfEmp.add(e);
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		if (listOfEmp.isEmpty()) {
			return null;
		}
		return listOfEmp;
	}

	public int deleteEmployeeById(int empId) {

		int delStatus = 0;
		try {
			Connection con = EmployeeUtility.getConnect();
			PreparedStatement ps = con.prepareStatement("delete from Employee_Table where empId = ?");
			ps.setInt(1, empId);
			delStatus = ps.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return delStatus;
	}

	public Employee getEmployeeById(int empId) {

		Employee emp = null;
		try {
			Connection con = EmployeeUtility.getConnect();
			PreparedStatement ps = con.prepareStatement("select * from Employee_Table where empId = ?");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double salary = rs.getDouble(3);
				long phone = rs.getLong(4);
				emp = new Employee();
				emp.setEmpId(id);
				emp.setEmpName(name);
				emp.setEmpSalary(salary);
				emp.setEmpPhone(phone);
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return emp;
	}

	public int updateEmployeeById(int empId) {

		int status = 0;
		try {
			Connection con = EmployeeUtility.getConnect();
			PreparedStatement ps = con
					.prepareStatement("Update Employee_Table set salary = ?, phone = ? where empId = ?");
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter salary to updated : ");
			double empSalary = Double.parseDouble(scanner.nextLine());
			ps.setDouble(1, empSalary);
			System.out.print("Enter phone no to be updated : ");
			long empPhone = Long.parseLong(scanner.nextLine());
			ps.setLong(2, empPhone);
			ps.setInt(3, empId);
			status = ps.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
