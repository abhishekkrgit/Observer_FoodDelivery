package org.kraabhi.model;


import lombok.Data;
import org.kraabhi.Constants.OrderStatus;

import java.time.Instant;

@Data
public class OrderEvent {
    private OrderStatus status;
    private String orderId;
    private Instant timeStamp;
    private String message;

    public OrderEvent(OrderStatus status, String orderId, Instant timeStamp, String message ) {
        this.orderId = orderId;
        this.status = status;
        this.timeStamp = timeStamp;
        this.message = message;
    }
}
