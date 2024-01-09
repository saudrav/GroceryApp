package com.saudrav.OrderService.service;

import com.saudrav.OrderService.model.AddOrderRequest;

public interface OrderService {
    Long placeOrder(AddOrderRequest addOrderRequest);
}
