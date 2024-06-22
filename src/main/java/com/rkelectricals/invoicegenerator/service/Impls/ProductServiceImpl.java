package com.rkelectricals.invoicegenerator.service.Impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Product> getProducts(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

}
