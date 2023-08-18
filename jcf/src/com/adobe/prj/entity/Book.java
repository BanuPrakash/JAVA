package com.adobe.prj.entity;

import com.adobe.prj.annotation.Column;
import com.adobe.prj.annotation.Table;

@Table(name="BOOKS")
public class Book {
	private int id;
	private String title;
	private double price;
	
	public Book() {
	}
	
	public Book(int id, String title, double price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}
	
	@Column(name="BOOK_ID", type="NUMERIC(10)")
	public int getId() {
		return id;
	}
	
	@Column(name="BOOK_TITLE")
	public String getTitle() {
		return title;
	}
	
	@Column(name="AMOUNT", type="NUMERIC(12,2)")
	public double getPrice() {
		return price;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(double price) {
		this.price = price;
	}	
}
