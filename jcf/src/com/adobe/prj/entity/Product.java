package com.adobe.prj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Comparable<Product> {
	private int id;
	private String name;
	private double price;
	private String category;
	
	@Override
	public int compareTo(Product o) {
		return this.id - o.id;
	}
}
