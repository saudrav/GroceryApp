package com.saudrav.ProductService.service;

import com.saudrav.ProductService.entity.Product;
import com.saudrav.ProductService.exception.ProductNotFoundException;
import com.saudrav.ProductService.exception.ProductQuantityOverloadException;
import com.saudrav.ProductService.model.ProductRequest;
import com.saudrav.ProductService.model.ProductResponse;
import com.saudrav.ProductService.repository.ProductServiceRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductServiceRepo productServiceRepo;

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Long addnewProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productServiceRepo.save(product);
        log.info("New  Product with id:"+product.getProductId()+" added successfully");
        return product.getProductId();
    }

    @Override
    public List<Product> getAll() {
        return productServiceRepo.findAll();
    }

    @Override
    public ProductResponse getProduct(Long id) {
        log.info("Getting product details for id:"+id);
        Product product
                = productServiceRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not Found"));

        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }

    @Override
    public void reduceQuantity(long id, int quantity) {
        log.info("Request received to reduce quantity {} for productId {}", quantity, id);
        Product prd = productServiceRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
        if(prd.getQuantity()>quantity) {
            prd.setQuantity(prd.getQuantity() - quantity);
        }
        else {
            throw new ProductQuantityOverloadException("we have only "+prd.getQuantity()+" number of items in our stock");
        }
        productServiceRepo.save(prd);
        log.info("Reduce Quantity request processed successfully.");
    }
}
