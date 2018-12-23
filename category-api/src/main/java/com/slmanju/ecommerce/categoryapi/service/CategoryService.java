package com.slmanju.ecommerce.categoryapi.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.slmanju.ecommerce.categoryapi.model.Category;

public interface CategoryService {

	Category save(Category category);

	Optional<Category> get(long id);

	Page<Category> getCategorysByPage(Integer pageNumber, Integer pageSize);

	void update(long id, Category category);

	void delete(long id);

}
