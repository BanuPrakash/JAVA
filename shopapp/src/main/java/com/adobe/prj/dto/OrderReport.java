package com.adobe.prj.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "dd/MMM/yyyy")
	Date orderDate;
	double total;
}
