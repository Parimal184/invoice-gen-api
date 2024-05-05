package com.rkelectricals.invoicegenerator.service;

import java.util.List;

import com.rkelectricals.invoicegenerator.model.Product;

public interface ProductService {
	
	Product saveProduct(Product product);
	
	List<Product> getProducts();
	
}
