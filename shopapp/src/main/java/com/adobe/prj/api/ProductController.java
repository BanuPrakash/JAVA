package com.adobe.prj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.EntityNotFoundException;
import com.adobe.prj.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/products")
@Validated
public class ProductController {
	@Autowired
	private OrderService service;

	// http://localhost:8080/api/products
	// http://localhost:8080/api/products?low=500&high=5000
	// returned List<Product> is given to HttpMessageConverter based on Accept header
	@GetMapping
	public List<Product> getProducts(@RequestParam(name = "low", defaultValue = "0.0") double low,
			@RequestParam(name = "high", defaultValue = "0.0") double high) {
		if(low == 0.0 && high == 0.0) {
			return service.getProducts();
		} else {
			return service.byRange(low, high);
		}
	}
	
	
	@Operation(summary = "Gets product by ID", description = "Product must exist")
	// http://localhost:8080/api/products/3
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") int id) throws EntityNotFoundException {
		return service.getProductById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product addProduct(@RequestBody @Valid Product p) {
		return service.addProduct(p);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable("id") int id, @RequestBody Product p) throws EntityNotFoundException {
		service.updateProduct(id, p);
		return service.getProductById(id);
	}
}
