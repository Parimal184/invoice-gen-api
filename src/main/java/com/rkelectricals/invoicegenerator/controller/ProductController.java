package com.rkelectricals.invoicegenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkelectricals.invoicegenerator.model.Product;
import com.rkelectricals.invoicegenerator.service.ProductService;

@RestController
@RequestMapping("/api/Product")
@CrossOrigin("*")
public class ProductController {
	
    @Autowired
    private ProductService productService;

    @PostMapping("/SaveProduct")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
    
    @GetMapping("/GetProducts")
    public ResponseEntity<?> getProducts() {
    	List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
