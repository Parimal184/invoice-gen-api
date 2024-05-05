package com.rkelectricals.invoicegenerator.service.Impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkelectricals.invoicegenerator.model.Product;
import com.rkelectricals.invoicegenerator.repository.ProductRepository;
import com.rkelectricals.invoicegenerator.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

}
