package com.ejb.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.StatefulEmployeeService;
import com.jpa.entities.Department;
import com.jpa.entities.Employee;

@Stateful
public class StatefulEmployeeServiceImpl implements StatefulEmployeeService {

	@PersistenceContext(name = "CRUDDemoApp")
	private EntityManager entityManager;
	
	private List<Employee> employeeList;
	private List<String> employeesName;
	
	/*@PostConstruct
	private void initializeBean() {
		// TODO Auto-generated method stub
		System.out.println("Inside constructor");
		employeeList = new ArrayList<>();
		employeesName = new ArrayList<>();
	}*/
	
	public StatefulEmployeeServiceImpl() {
		System.out.println("Inside constructor");
		employeeList = new ArrayList<>();
		employeesName = new ArrayList<>();
	}
	
	@Override
	public void addEmployeeToState(Employee employee, int departmentId) {
		// TODO Auto-generated method stub
		System.out.println("Inside addEmployeeToState method");
		Department department = new Department();
		department.setDepartment_id(departmentId);
		employee.setDepartment(department);
		employeeList.add(employee);
		employeesName.add(employee.getEmployee_name());
		System.out.println("Size of list: " + employeeList.size());
		System.out.println("Size of name list: " + employeesName.size());
	}

	@Override
	@Remove
	public void addEmployeeToDB() {
		// TODO Auto-generated method stub
		System.out.println("Inside addEmployeeToDB method");
		System.out.println("Size of employee list: " + employeeList.size());
		System.out.println("Size of name list: " + employeesName.size());
		for(Employee employee : employeeList) {
			entityManager.persist(employee);
		}
		employeeList.clear();
	}

	@Override
	public void getEmployeeListSize() {
		// TODO Auto-generated method stub
		System.out.println("Inside getEmployeeListSize method");
		System.out.println("Size of employee list: " + employeeList.size());
		System.out.println("Size of name list: " + employeesName.size());
	}

}
