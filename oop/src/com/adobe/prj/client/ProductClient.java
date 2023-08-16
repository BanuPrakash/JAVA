package com.adobe.prj.client;

import java.lang.reflect.Method;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;

public class ProductClient {

	public static void main(String[] args) {
		Product[] products = new Product[5]; // array of pointers
		products[0] = new Mobile(23, "Samsung Fold", 1200000.00, "4G"); // upcasting
		products[1] = new Tv(52,"Onida thunder", 3500.00, "CRT"); // upcasting
		products[2] = new Tv(51, "Sony Bravia", 298000.00, "OLED"); // upcasting
		products[3] = new Mobile(61,"Nokia", 5000.00, "3G"); // upcasting
		products[4] = new Product(56, "Dummy", 0); // upcasting
		
		printExpensive(products);
		printDetails(products);
		
		System.out.println("******");
		printDetailsOCP(products);
	}

	// OCP
	private static void printDetailsOCP(Product[] products) {
		for(Product p : products) {
			System.out.println("#####");
			Method[] methods = p.getClass().getMethods(); // methods + inherited methods
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					try {
							Object ret = m.invoke(p); // invoke "method -> m" on "context p"
							System.out.println(m.getName().substring(3).toUpperCase() + " : " + ret);
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			System.out.println("-----");
		}
	}

	// Not OCP
	 private static void printDetails(Product[] products) {
		 for(Product p : products) {
			 System.out.println(p.getName() + ", " + p.getPrice());
			 if(p instanceof Mobile) {
				 Mobile m = (Mobile) p; // down-casting
				 System.out.println(m.getConnectivity());
			 } else if(p.getClass() == Tv.class) {
				 Tv t = (Tv) p;
				 System.out.println(t.getScreenType());
			 } 
		 }
	}

	// OCP
	private static void printExpensive(Product[] products) {
		for(Product p : products) {
			if(p.isExpensive()) { // polymorphism, dynamic binding
				System.out.println(p.getName() + " is expensive");
			} else {
				System.out.println(p.getName() + " is not expensive");
			}
		}
	}

}
