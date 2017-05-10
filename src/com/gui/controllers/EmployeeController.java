package com.gui.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.services.EmployeeService;
import com.jpa.entities.Employee;

@ManagedBean
public class EmployeeController {

	private int department_id;
	private Employee employee = new Employee();
	private Employee selectedEmployee;
	
	@EJB
	private EmployeeService service;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	public String saveEmployee(Employee emp, int department_id) {
		service.addEmployee(emp, department_id);
		return "home";
	}
	
	public List<Employee> getEmployeeList() {
		return service.getEmployee();
	}
	
	public String removeEmployee(Employee employee) {
		service.removeEmployee(employee);
		return null;
	}
	
	public String updateEmployee(Employee employee, int department_id) {
		service.updateEmployee(employee, department_id);
		return "home";
	}
}
