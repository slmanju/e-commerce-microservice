package com.slmanju.ecommerce.productapi.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.slmanju.ecommerce.productapi.model.Product;

public interface ProductService {

   Product save(Product product);
   
   Optional<Product> get(long id);
   
   Page<Product> getProductsByPage(Integer pageNumber, Integer pageSize);
   
   void update(long id, Product product);
   
   void delete(long id);

}
