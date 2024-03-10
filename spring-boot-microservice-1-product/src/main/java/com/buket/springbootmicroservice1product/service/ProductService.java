package com.buket.springbootmicroservice1product.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.buket.springbootmicroservice1product.model.Product;
import com.buket.springbootmicroservice1product.repository.IProductRepository;

@Service
public class ProductService implements IProductService {

	private final IProductRepository iProductRepository;

	public ProductService(IProductRepository iProductRepository) {
		this.iProductRepository = iProductRepository;
	}

	public Product saveProduct(Product product) {
		product.setCreatedTime(LocalDateTime.now());
		return iProductRepository.save(product);
	}

	public void deleteProduct(Long productId) {
		iProductRepository.deleteById(productId);
	}

	public List<Product> findAllProducts() {
		return iProductRepository.findAll();
	}

}
