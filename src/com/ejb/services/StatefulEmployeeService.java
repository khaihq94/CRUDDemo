package com.ejb.services;

import com.jpa.entities.Employee;

public interface StatefulEmployeeService {
	
	public void addEmployeeToState(Employee employee, int departmentId);
	
	public void addEmployeeToDB();
	
	public void getEmployeeListSize();

}
