package com.adobe.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adobe.prj.entity.Product;

// Product refers to which entity it needs CRUD, Integer --> type of primary integer
public interface ProductDao extends JpaRepository<Product, Integer> {

}
