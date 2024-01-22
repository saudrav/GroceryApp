package com.saudrav.OrderService.service;

import com.saudrav.OrderService.entity.Order;
import com.saudrav.OrderService.exception.OrderNotFoundException;
import com.saudrav.OrderService.model.AddOrderRequest;
import com.saudrav.OrderService.model.OrderDetailsResponse;
import com.saudrav.OrderService.repository.OrderServiceRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderServiceRepo orderServiceRepo;

    @Override
    public Long placeOrder(AddOrderRequest addOrderRequest) {
        //save Order Entity and order-status=Created
        log.info("Initiating new order Request");
        Order order = Order.builder()
                .prodctId(addOrderRequest.getProdctId())
                .orderDate(Instant.now())
                .quantity(addOrderRequest.getQuantity())
                .amount(addOrderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .build();
        order = orderServiceRepo.save(order);

        log.info("Order created successfully with order id: "+order.getId());
        //check stock availability from product-service

        //trigger payment service to confirm payment status
        //order-status = Confirm
        //order-status = Canceled

        return order.getId();
    }

    @Override
    public OrderDetailsResponse getOrderDetailsByID(String id) {
        Order order = orderServiceRepo.findById(Long.parseLong(id))
                        .orElseThrow(() -> new EntityNotFoundException("Invalid orderId"));
        return OrderDetailsResponse.builder()
                .orderId(order.getId())
                .prodctId(order.getProdctId())
                .orderDate(order.getOrderDate())
                .quantity(order.getQuantity())
                .orderStatus(order.getOrderStatus())
                .totalAmount(order.getAmount())
                .build();
    }

}
