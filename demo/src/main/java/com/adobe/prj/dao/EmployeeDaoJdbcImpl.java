package com.adobe.prj.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.adobe.prj.entity.Employee;

@Profile("prod")
@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {

	@Override
	public void addEmployee(Employee e) {
		System.out.println("stored in RDBMS!!!");
	}

}
