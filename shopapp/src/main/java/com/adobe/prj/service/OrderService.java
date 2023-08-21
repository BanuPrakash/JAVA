package com.adobe.prj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.CustomerDao;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	public List<Product> getProducts() {
		return productDao.findAll();
	}
	
	public Product getProductById(int id) {
		Optional<Product> p =  productDao.findById(id);
		if(p.isPresent()) {
			return p.get();
		}
		return null;
	}
	
	public Product addProduct(Product p) {
		return productDao.save(p);
	}
	
	
	public List<Customer> getCustomers() {
		return customerDao.findAll();
	}
	
	public Customer getCustomerByEmail(String email) {
		Optional<Customer> c =  customerDao.findById(email);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}
	
	public Customer addCustomer(Customer c) {
		return customerDao.save(c);
	}
}
