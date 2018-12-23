package com.slmanju.ecommerce.categoryapi.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.slmanju.ecommerce.categoryapi.model.Category;
import com.slmanju.ecommerce.categoryapi.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping("")
	public ResponseEntity<?> createCategory(@RequestBody Category category) {
		Category savedCategory = categoryService.save(category);
		return ResponseEntity.ok().body("New Category has been saved with ID:" + savedCategory.getId());
	}

	@GetMapping("")
	public @ResponseBody Page<Category> getCategoriesByPage(
			@RequestParam(value = "pagenumber", defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "pagesize", defaultValue = "20") Integer pageSize) {
		Page<Category> pagedCategorys = categoryService.getCategorysByPage(pageNumber, pageSize);
		return pagedCategorys;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Category getCategory(@PathVariable("id") long id) {
		Optional<Category> returnedCategory = categoryService.get(id);
		Category category = returnedCategory.get();
		return category;
	}

	@PutMapping("/category/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
		categoryService.update(id, category);
		return ResponseEntity.ok().body("Category has been updated successfully.");
	}

	@DeleteMapping("/category/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") long id) {
		categoryService.delete(id);
		return ResponseEntity.ok().body("Category has been deleted successfully.");
	}

}