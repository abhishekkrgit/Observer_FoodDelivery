package org.kraabhi.Subject;

import lombok.Data;
import org.kraabhi.Constants.OrderStatus;
import org.kraabhi.Observers.Observer;
import org.kraabhi.model.OrderEvent;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
public class Order implements OrderSubjects{
    private String status;
    private String orderId;
    private String restaurantName;
    private String customerName;
    private String deliveryPartnerName;
    private final List<Observer> observerList = new CopyOnWriteArrayList<>();

    public Order(String orderId, String restaurantName, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.status = OrderStatus.CONFIRMED.name();
    }

    // Business methods that change state and notify observers
    public void confirm() {
        this.status = OrderStatus.CONFIRMED.name();
        notify(new OrderEvent(OrderStatus.CONFIRMED, orderId, Instant.now(), "Order Confirmed"));
    }

    public void startPreparing() {
        this.status = OrderStatus.PREPARING.name();
        notify(new OrderEvent(OrderStatus.PREPARING, orderId, Instant.now(), "Started Preparing"));
    }

    public void outForDelivery(String riderName) {
        setDeliveryPartnerName(riderName);
        this.status = OrderStatus.OUT_FOR_DELIVERY.name();
        notify(new OrderEvent(OrderStatus.OUT_FOR_DELIVERY, orderId, Instant.now(),"Order out for delivery"));
    }

    public void deliver() {
        this.status = OrderStatus.DELIVERED.name();
        notify(new OrderEvent(OrderStatus.DELIVERED, orderId, Instant.now(), "Order Delivered Successfully"));
    }

    public void cancel(String reason) {
        this.status = OrderStatus.CANCELLED.name();
        notify(new OrderEvent(OrderStatus.CANCELLED, orderId, Instant.now(), reason));
    }

    @Override
    public void addObserver(Observer obs){
        this.observerList.add(obs);
    }

    @Override
    public void removeObserver(Observer obs){
        observerList.remove(obs);
    }

    @Override
    public void notify (OrderEvent orderEvent){
        for(Observer obs: observerList){
            obs.onUpdate(orderEvent);
        }
    }
}
