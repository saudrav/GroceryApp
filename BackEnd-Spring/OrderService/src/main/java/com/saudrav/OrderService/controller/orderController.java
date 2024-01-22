package com.saudrav.OrderService.controller;

import com.saudrav.OrderService.model.AddOrderRequest;
import com.saudrav.OrderService.model.OrderDetailsResponse;
import com.saudrav.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

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

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailsResponse> getOrderDetailsById(@PathVariable("id") String id) {
        OrderDetailsResponse orderDetailsResponse = orderService.getOrderDetailsByID(id);
        //return ResponseEntity.ok(orderDetailsResponse);
        //return ResponseEntity.status(HttpStatus.OK).body(orderDetailsResponse);
        return new ResponseEntity<>(orderDetailsResponse, HttpStatus.OK);
    }


}
