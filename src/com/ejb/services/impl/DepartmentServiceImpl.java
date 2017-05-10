package com.ejb.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.services.DepartmentService;
import com.jpa.entities.Department;

@Stateless
public class DepartmentServiceImpl implements DepartmentService {

	@PersistenceContext(name = "CRUDDemoApp")
	private EntityManager em;
	
	@Override
	public String addDepartment(Department dep) {
		em.persist(dep);
		em.flush();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartment() {
		List<Department> depList = new ArrayList<>();
		
		String ejbQL = "FROM Department";
		Query query = em.createQuery(ejbQL);
		depList = query.getResultList();
		return depList;
	}

}
