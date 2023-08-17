package com.adobe.prj.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.adobe.prj.entity.Product;

public class StreamExample {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();

		products.add(new Product(53, "Wacom", 5600.00, "computer"));
		products.add(new Product(61, "Sony Bravia", 298000.00, "tv"));
		products.add(new Product(891, "Logitech Mouse", 890.00, "computer"));
		products.add(new Product(4, "iPhone 14", 78000.00, "mobile"));
		products.add(new Product(62, "Oneplus Nord", 56000.00, "mobile"));
		
		List<Product> computers = 
				products.stream()
				.filter(p -> p.getCategory().equals("computer"))
				.collect(Collectors.toList());

		for(Product p : computers) {
			System.out.println(p);
		}
		
		System.out.println("**********");
		
		products.stream()
		.filter(p -> p.getCategory().equals("computer"))
		.forEach(p -> System.out.println(p));
		

		System.out.println("**********");
		
		System.out.println("Get total price of computer");
		
		Optional<Double> total = products.stream()
		.filter(p -> p.getCategory().equals("computer"))
		.map(p -> p.getPrice())
		.reduce((v1,v2) -> v1 + v2);
		
		if(total.isPresent()) {
			System.out.println(total.get());
		}
		
		
	}

}
