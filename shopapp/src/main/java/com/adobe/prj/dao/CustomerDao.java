package com.adobe.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adobe.prj.entity.Customer;


//Customer refers to which entity it needs CRUD, String --> type of primary integer
public interface CustomerDao extends JpaRepository<Customer, String> {

}

