package com.rkelectricals.invoicegenerator.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rkelectricals.invoicegenerator.model.Product;

public interface ProductService {
	
	Product saveProduct(Product product);
	
	Page<Product> getProducts(Pageable pageable);
	
	void deleteProduct(Long id);
	
	Product updateProduct(Product product);
}
