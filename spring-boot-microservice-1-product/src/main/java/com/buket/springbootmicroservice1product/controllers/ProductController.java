package com.buket.springbootmicroservice1product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buket.springbootmicroservice1product.model.Product;
import com.buket.springbootmicroservice1product.service.IProductService;

@RestController
@RequestMapping("api/product") //pre-path
public class ProductController
{
    @Autowired
    private IProductService productService;

    @PostMapping("/saveProduct") // -> api/product
    public ResponseEntity<?> saveProduct(@RequestBody Product product)
    {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("{productId}") //-> api/product/productId
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId)
    {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping // -> api/product
    public ResponseEntity<?> getAllProducts()
    {
        return ResponseEntity.ok(productService.findAllProducts());
    }
}
