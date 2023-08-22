package com.adobe.prj.api;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/sample")
@RestController
public class SampleController {

	//http://localhost:8080/api/sample?order-date=3-10-2002
	@GetMapping
	public String test(@RequestParam("order-date") @DateTimeFormat(pattern="dd-MM-yyyy") Date d) {
		System.out.println(d);
		return "done";
	}
}
