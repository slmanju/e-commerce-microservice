package com.slmanju.ecommerce.productapi.controller;

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

import com.slmanju.ecommerce.productapi.model.Product;
import com.slmanju.ecommerce.productapi.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

   private final ProductService productService;
   
   public ProductController(ProductService productService) {
	   this.productService = productService;
   }

   @GetMapping("")
   public @ResponseBody Page<Product> getProductsByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
      Page<Product> pagedProducts = productService.getProductsByPage(pageNumber, pageSize);
      return pagedProducts;
   }
   
   @PostMapping("")
   public ResponseEntity<?> createProduct(@RequestBody Product product) {
      Product savedProduct = productService.save(product);
      return ResponseEntity.ok().body("New Product has been saved with ID:" + savedProduct.getId());
   }

   @GetMapping("/{id}")
   public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
	  Optional<Product> returnedProduct = productService.get(id);
	  Product product  = returnedProduct.get(); 
      return ResponseEntity.ok().body(product);
   }

   @PutMapping("/{id}")
   public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
      productService.update(id, product);
      return ResponseEntity.ok().body("Product has been updated successfully.");
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
      productService.delete(id);
      return ResponseEntity.ok().body("Product has been deleted successfully.");
   }

}