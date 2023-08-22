package com.adobe.prj.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderReport {
	String email;
	String firstName;
	String lastName;
	Date orderDate;
	double total;
}
