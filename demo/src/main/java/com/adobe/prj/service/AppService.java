package com.adobe.prj.service;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.EmployeeDao;
import com.adobe.prj.entity.Employee;

@Service
public class AppService {
	@Autowired
	private EmployeeDao employeeDao; // interface
	
	@Autowired
	DataSource ds;
	
	public void insert(Employee e) {
		employeeDao.addEmployee(e);
		try {
			System.out.println("Connection object " + ds.getConnection());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
}
