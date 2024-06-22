package com.rkelectricals.invoicegenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<?> getProducts(@RequestParam(required = false, defaultValue = "0") Integer page,
	        @RequestParam(required = false, defaultValue = "10") Integer size) {
    	Page<Product> products = productService.getProducts(PageRequest.of(page, size));
    	System.out.println("products :"+ products.getContent());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    
    @PutMapping("/UpdateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
    
    @DeleteMapping("/DeleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
    	productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
