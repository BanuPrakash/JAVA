package com.adobe.prj.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

//@Component
public class ProductClient implements CommandLineRunner {
	@Autowired
	private OrderService service;
	@Override
	public void run(String... args) throws Exception {
		// code gets executed as soon as Spring container is created
		//addProduct();
		//listProducts();
		//getProductById();
		productsByPrice();
	}
		
	private void productsByPrice() {
		List<Product> products = service.byRange(5000, 50000);
		for(Product p : products) {
			System.out.println(p);
		}
	}

	private void addProduct() {
		Product p = Product.builder().name("Macbook Pro").price(2_20_000.00).quantity(100).build();
		service.addProduct(p);
		System.out.println("Product added successfully!!!");
	}

	private void listProducts() {
		List<Product> products = service.getProducts();
		for(Product p : products) {
			System.out.println(p);
		}
	}
	
	private void getProductById() {
		System.out.println("#####");
			Product p = service.getProductById(2);
			System.out.println(p);
		System.out.println("#####");
	}
}
