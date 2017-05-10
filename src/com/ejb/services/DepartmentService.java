package com.ejb.services;

import java.util.List;

import com.jpa.entities.Department;

public interface DepartmentService {

	public String addDepartment(Department dep);
	
	public List<Department> getDepartment();
}
