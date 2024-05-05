package com.rkelectricals.invoicegenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rkelectricals.invoicegenerator.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
