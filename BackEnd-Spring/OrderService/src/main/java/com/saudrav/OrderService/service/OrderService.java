package com.saudrav.OrderService.service;

import com.saudrav.OrderService.model.AddOrderRequest;
import com.saudrav.OrderService.model.OrderDetailsResponse;

public interface OrderService {
    Long placeOrder(AddOrderRequest addOrderRequest);
    OrderDetailsResponse getOrderDetailsByID(String id);
}
