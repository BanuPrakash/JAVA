package com.adobe.prj.client;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;
import com.adobe.prj.util.Utility;

public class SortClient {

	public static void main(String[] args) {
		String[] names = {"Nolan", "Scarlett", "Angelina", "Lucy", "Brad", "George"};
		
		Utility.sort(names);
		
		for(String name : names) {
			System.out.println(name);
		}
		
		Product[] products = new Product[4]; // array of pointers
		products[0] = new Mobile(23, "Samsung Fold", 120000.00, "4G"); // upcasting
		products[1] = new Tv(52,"Onida thunder", 3500.00, "CRT"); // upcasting
		products[2] = new Tv(51, "Sony Bravia", 298000.00, "OLED"); // upcasting
		products[3] = new Mobile(61,"Nokia", 5000.00, "3G"); // upcasting
	
		Utility.sort(products);
		
		for(Product p : products) {
			System.out.println(p); // object as argument toString() is called
		}
	}

}
