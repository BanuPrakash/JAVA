package com.adobe.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.EmployeeDao;
import com.adobe.prj.entity.Employee;

@Service
public class AppService {
	@Autowired
	private EmployeeDao employeeDao; // interface
	
	public void insert(Employee e) {
		employeeDao.addEmployee(e);
	}
}
