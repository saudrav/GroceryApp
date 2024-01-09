package com.saudrav.ProductService.repository;

import com.saudrav.ProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductServiceRepo extends JpaRepository<Product, Long> {

}
