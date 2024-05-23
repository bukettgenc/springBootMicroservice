package com.buket.springbootmicroservice1product.service;

import java.util.List;

import com.buket.springbootmicroservice1product.model.Product;

public interface IProductService
{
    Product saveProduct(Product product);

    void deleteProduct(Long productId);

    List<Product> findAllProducts();
}