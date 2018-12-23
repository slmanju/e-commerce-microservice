package com.slmanju.ecommerce.categoryapi.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.slmanju.ecommerce.categoryapi.model.Category;
import com.slmanju.ecommerce.categoryapi.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	  final static Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

   @Autowired
   private CategoryRepository categoryRepository;  
  
   public Category save(Category category) {
      return categoryRepository.save(category);
   }

   public Optional<Category> get(long id) {
      return categoryRepository.findById(id);
   }

   public Page<Category> getCategorysByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("categoryName").descending());
	   return categoryRepository.findAll(pageable);
   }

   public void update(long id, Category category) {
      categoryRepository.save(category);
   }
   
   public void delete(long id) {
      categoryRepository.deleteById(id);
   }

}
