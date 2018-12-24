package com.slmanju.ecommerce.productapi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category-api")
public interface CategoryServiceProxy {

	@GetMapping("/categories/{id}")
	CategoryResponse getCategory(@PathVariable("id") long id);

}
