package com.slmanju.ecommerce.categoryapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.slmanju.ecommerce.categoryapi.model.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

	Page<Category> findAll(Pageable pageable);
}
