package com.adobe.prj.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.adobe.prj.entity.Product;

public class ListExample {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();

		products.add(new Product(53, "Wacom", 5600.00, "computer"));
		products.add(new Product(61, "Sony Bravia", 298000.00, "tv"));
		products.add(new Product(891, "Logitech Mouse", 890.00, "computer"));
		products.add(new Product(4, "iPhone 14", 78000.00, "mobile"));
		products.add(new Product(62, "Oneplus Nord", 56000.00, "mobile"));

		Collections.sort(products);

		for (Product p : products) {
			System.out.println(p);
		}

		System.out.println("*******");

		Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));

		for (Product p : products) {
			System.out.println(p);
		}

	}

}
