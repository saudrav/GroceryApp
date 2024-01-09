package com.saudrav.OrderService.controller;

import com.saudrav.OrderService.model.AddOrderRequest;
import com.saudrav.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class orderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeorder(@RequestBody AddOrderRequest addOrderRequest) {

        Long id = orderService.placeOrder(addOrderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);

    }


}
