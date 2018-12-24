package com.slmanju.ecommerce.productapi.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.slmanju.ecommerce.productapi.model.Product;
import com.slmanju.ecommerce.productapi.repository.ProductRepository;

import feign.FeignException;

@Service
public class ProductServiceImpl implements ProductService {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	private final ProductRepository productRepository;
	private final CategoryServiceProxy categoryServiceProxy;
	
	public ProductServiceImpl(ProductRepository productRepository, CategoryServiceProxy categoryServiceProxy) {
		this.productRepository = productRepository;
		this.categoryServiceProxy = categoryServiceProxy;
	}

	public Product save(Product product) {
		validateCategory(product.getCategoryId());
		return productRepository.save(product);
	}

	public Optional<Product> get(long id) {
		return productRepository.findById(id);
	}

	public Page<Product> getProductsByPage(Integer pageNumber, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("productCode").descending());
		return productRepository.findAll(pageable);
	}

	public void update(long id, Product product) {
		productRepository.save(product);
	}

	public void delete(long id) {
		productRepository.deleteById(id);
	}
	
	public void validateCategory(Long id) {
		try {
			CategoryResponse category = categoryServiceProxy.getCategory(id);
			System.out.println("-------------> " + category.getCategoryName());
		} catch(FeignException exception) {
			
		}
	}

}
