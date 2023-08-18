package com.adobe.prj.client;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
//		Map<String, Double> booksMap = new HashMap<>();
		Map<String, Double> booksMap = new HashMap<>(25, 0.7f); // initial bucket size is 25, loadfactor  is 70%
		// once 70% of 25 are filled capacity doubles [ 25 --> 50, 50 --> 100, 100 -> 200]
		booksMap.put("React", 1234.11);
		booksMap.put("JavaScript", 780.11);
		booksMap.put("Java", 890.00);
		booksMap.put("MySQL", 3450.01);
		
		
		booksMap.put("Java", 1290.00); // overwrite old entry
		
		double d = booksMap.get("React");
		
		System.out.println(d);
		
		booksMap.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		
		System.out.println(booksMap.containsKey("Java"));
	}

}
