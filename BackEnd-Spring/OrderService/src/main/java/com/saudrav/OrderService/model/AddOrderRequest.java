package com.saudrav.OrderService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddOrderRequest {
    private long prodctId;
    private long quantity;
    private long totalAmount;
    private PaymentMode paymentMode;
}
