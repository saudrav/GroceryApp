package com.saudrav.ProductService.service;

import com.saudrav.ProductService.entity.Product;
import com.saudrav.ProductService.model.ProductRequest;
import com.saudrav.ProductService.model.ProductResponse;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    Long addnewProduct(ProductRequest productRequest);

    List<Product> getAll();

    ProductResponse getProduct(Long id);

    void reduceQuantity(long id, int quantity);
}
