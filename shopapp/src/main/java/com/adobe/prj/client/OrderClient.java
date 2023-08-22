package com.adobe.prj.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.LineItem;
import com.adobe.prj.entity.Order;
import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@Component
public class OrderClient implements CommandLineRunner {
	
	@Autowired
	private OrderService service;
	
	@Override
	public void run(String... args) throws Exception {
		checkout();	
	}

	private void checkout() {
		Order order = new Order();
		LineItem item1 = LineItem.builder()
				.product(Product.builder().id(3).build())
				.qty(1).build();
		
		LineItem item2 = LineItem.builder()
				.product(Product.builder().id(1).build())
				.qty(2).build();
		
		order.getItems().add(item1);
		order.getItems().add(item2);
		
		Customer customer = Customer.builder().email("sam@adobe.com").build();
		
		order.setCustomer(customer);
		
		service.placeOrder(order);
	}

}
