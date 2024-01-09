package com.saudrav.OrderService.repository;

import com.saudrav.OrderService.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServiceRepo extends JpaRepository<Order, Long> {
}
