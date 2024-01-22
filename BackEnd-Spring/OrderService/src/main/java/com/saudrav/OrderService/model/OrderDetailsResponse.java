package com.saudrav.OrderService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailsResponse {
    private long orderId;
    private long prodctId;
    private long quantity;
    private Instant orderDate;
    private String orderStatus;
    private long totalAmount;
}
