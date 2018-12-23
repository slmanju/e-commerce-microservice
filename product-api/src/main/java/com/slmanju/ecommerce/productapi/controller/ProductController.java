package com.slmanju.ecommerce.productapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@GetMapping("")
	public Greeting index() {
		return new Greeting("Hello world");
	}
	
}
