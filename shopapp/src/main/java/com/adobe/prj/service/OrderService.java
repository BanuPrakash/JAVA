package com.adobe.prj.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.CustomerDao;
import com.adobe.prj.dao.OrderDao;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dto.OrderReport;
import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.LineItem;
import com.adobe.prj.entity.Order;
import com.adobe.prj.entity.Product;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private OrderDao orderDao;
	
	public List<Order> getOrderForDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // format understood by mySQL
		String dateStr = sdf.format(date);
		return orderDao.getOrdersForDate(dateStr);
	}
	
	@Transactional
	public void updateProduct(int id, Product p) {
		productDao.updateProductPrice(id, p.getPrice());
	}
	
	public List<OrderReport> getReport() {
		return orderDao.getReport();
	}
	
	public List<Order> getOrders() {
		return orderDao.findAll();
	}
	
	/*
	 {
    	customer:{"email": "sam@adobe.com"},
    	"items": [
        	{"product": {id:3}, qty: 1},
        	{"product": {id:1}, qty: 2}
    	]
	}
	 */
	@Transactional
	public void placeOrder(Order order) {
		double total = 0.0;
		List<LineItem> items = order.getItems();
		for(LineItem item : items) {
			Product p = productDao.findById(item.getProduct().getId()).get();
			if(p.getQuantity() < item.getQty()) {
				throw new IllegalArgumentException("Product " + p.getName() + " not in Stock!!!");
			}
			p.setQuantity(p.getQuantity() - item.getQty()); // dirty --> update 
			item.setAmount(p.getPrice() * item.getQty()); // discount, tax
			total += item.getAmount();
		}
		order.setTotal(total);
		orderDao.save(order); // cascade takes care of saving items also
	}
	
	
	public List<Product> byRange(double low, double high) {
		return productDao.getByRange(low, high);
	}
	
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
