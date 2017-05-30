package com.gui.controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.services.StatefulEmployeeService;
import com.jpa.entities.Employee;

@ManagedBean(name="statefulEmployee")
public class StatefulEmployeeController {

	@EJB
	private StatefulEmployeeService service;
	
	private Employee employee = new Employee();
	private int department_id;
	
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
	
	public void addEmployeeToState(Employee employee, int departmentId) {
		service.addEmployeeToState(employee, departmentId);
	}
	
	public void addEmployeeToDB() {
		service.addEmployeeToDB();
	}
	
	public void getEmployeeListSize() {
		service.getEmployeeListSize();
	}
	
}
