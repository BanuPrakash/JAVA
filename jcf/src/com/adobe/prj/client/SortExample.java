package com.adobe.prj.client;

import java.util.Arrays;

import com.adobe.prj.entity.Product;


public class SortExample {

	public static void main(String[] args) {
		String[] names = {"Nolan", "Scarlett", "Angelina", "Lucy", "Brad", "George"};
		// String implements Comparable
		Arrays.sort(names);
		
		for(String name : names) {
			System.out.println(name);
		}
		
		System.out.println("******");
		
//		Arrays.sort(names, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.length() - o2.length();
//			}
//		});
//		
		
		Arrays.sort(names, (o1,o2) -> o1.length() - o2.length());
		for(String name : names) {
			System.out.println(name);
		}
		
		System.out.println("******");
		Product[] products = new Product[5];
		products[0] = new Product(53, "Wacom", 5600.00, "computer");
		products[1] = new Product(61, "Sony Bravia", 298000.00, "tv");
		products[2] = new Product(891, "Logitech Mouse", 890.00, "computer");
		products[3] = new Product(4, "iPhone 14", 78000.00, "mobile");
		products[4] = new Product(62, "Oneplus Nord", 56000.00, "mobile");
		
		Arrays.sort(products);// uses logic which is part of Product object itself
		for(Product p : products) {
			System.out.println(p);
		}
		
		System.out.println("******");
		Arrays.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
		
		for(Product p : products) {
			System.out.println(p);
		}
		
		System.out.println("******");
		Arrays.sort(products, (p1, p2) -> p1.getName().compareTo(p2.getName()));
		
		for(Product p : products) {
			System.out.println(p);
		}
	}

}
