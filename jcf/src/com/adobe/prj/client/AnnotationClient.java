package com.adobe.prj.client;

import com.adobe.prj.entity.Book;
import com.adobe.prj.entity.Employee;
import com.adobe.prj.util.SQLUtil;

public class AnnotationClient {

	public static void main(String[] args) {
		String createSQL = SQLUtil.createStatement(Book.class);
		System.out.println(createSQL);
		
		createSQL = SQLUtil.createStatement(Employee.class);
		System.out.println(createSQL);
	}

}
