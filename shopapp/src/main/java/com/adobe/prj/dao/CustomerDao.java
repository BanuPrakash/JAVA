package com.adobe.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adobe.prj.entity.Customer;


//Customer refers to which entity it needs CRUD, String --> type of primary integer
public interface CustomerDao extends JpaRepository<Customer, String> {
 // get all customers based on first name
	// select * from customers where first_name = ?
	List<Customer> findByFirstName(String name);
	
	// select * from customers where first_name = ? and last_name = ?
	List<Customer> findByFirstNameAndLastName(String fname, String lname);
	
	// select * from customers where first_name = ? OR last_name = ?
	List<Customer> findByFirstNameOrLastName(String fname, String lname);
	
}

