package com.slmanju.ecommerce.productapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.slmanju.ecommerce.productapi.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	Page<Product> findAll(Pageable pageable);

}
