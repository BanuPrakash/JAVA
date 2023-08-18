package com.adobe.prj.util;

import java.lang.reflect.Method;

import com.adobe.prj.annotation.Column;
import com.adobe.prj.annotation.Table;

public class SQLUtil {

	// create table BOOKS (BOOK_ID NUMERIC(10), BOOK_TITLE VARCHAR(100), AMOUNT NUMERIC(12,2))
	// create table EMP (EMP_ID NUMERIC(10), ENAME VARCHAR(100), SAL NUMERIC(12,2))
	public static String createStatement(Class<?> clazz) {
		StringBuilder builder = new StringBuilder();
		Table table = clazz.getAnnotation(Table.class);
		if( table != null) {
			builder.append("create table ");
			builder.append(table.name()); 
			builder.append("("); // create table BOOKS (
			
			Method[] methods = clazz.getDeclaredMethods(); // not inherited
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					Column col = m.getAnnotation(Column.class);
					if(col != null) {
						builder.append(col.name()); // create table BOOKS(BOOK_ID
						builder.append(" ");
						builder.append(col.type()); // create table BOOKS(BOOK_ID NUMERIC(10)
						builder.append(","); // create table BOOKS(BOOK_ID NUMERIC(10), 
					}
				}
			}
			builder.setCharAt(builder.lastIndexOf(","), ')');
		}
		
		return builder.toString();
	}
	
	// insert into books values (...)
	// insert into emp values (...)
	public static String insertSQL() {
		return null;
	}
}
