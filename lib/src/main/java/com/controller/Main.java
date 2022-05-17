package com.controller;

import java.util.List;
import java.util.Scanner;

import com.dao.EmployeeServiceImpl;
import com.model.Employee;
import com.service.EmployeeService;

public class Main {
	public static void main(String[] args) {
		
		EmployeeService service = new EmployeeServiceImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the no of Employee : ");
		int nOE = Integer.parseInt(scanner.nextLine());
		for(int i= 0; i<nOE; i++) {
			Employee e = new Employee();
			System.out.println("Enter id");
			int id = Integer.parseInt(scanner.nextLine());
			System.out.println("Enter name");
			String eName = scanner.nextLine();
			System.out.println("Enter salary");
			double salary = Double.parseDouble(scanner.nextLine());
			System.out.println("Enter Phone number");
			long phone = Long.parseLong(scanner.nextLine());
			e.setEmpId(id);
			e.setEmpName(eName);
			e.setEmpSalary(salary);
			e.setEmpPhone(phone);
			
			if(service.addEmployee(e)) {
				System.out.println(i+1 + " " + "object inserted");
			}
		}
		
		// calling getEmployee()
		List<Employee> listOfEmp = service.getAllEmployee();
		for(Employee e : listOfEmp) {
			System.out.println(e.getEmpId() + " "   + e.getEmpName() + " " + e.getEmpSalary() + " " + e.getEmpPhone());
			
		}
		System.out.println("delete employee object based on id");
		int id = Integer.parseInt(scanner.nextLine());
		int k = service.deleteEmployeeById(id);
	if(k>0) {
			System.out.println("Deleted");
		}
		
		System.out.println("get Employee by Id");
		int id1 = Integer.parseInt(scanner.nextLine());
		Employee e = service.getEmployeeById(id1);
//		System.out.println(e);
		if(id1 > 0) {
			System.out.println(e.getEmpId() + " " + e.getEmpName() + " " + e.getEmpPhone() + " " + e.getEmpSalary());
		}
		System.out.println("update employee by Id");
		int id2 = Integer.parseInt(scanner.nextLine());
		int x = service.updateEmployeeById(id2);
			if(x > 0) {
			Employee e1 = service.getEmployeeById(id2);
			System.out.println(e1.getEmpId() + " " + e1.getEmpName() + " " + e1.getEmpSalary() + " " + e1.getEmpPhone());
			System.out.println("Updated");
			
		}
	}

}
