package org.kraabhi;

import org.kraabhi.Observers.impl.Customer;
import org.kraabhi.Observers.impl.DeliveryPartner;
import org.kraabhi.Observers.impl.Restaurants;
import org.kraabhi.Subject.Order;


public class Main {
    public static void main(String[] args) {
        Restaurants restaurant = new Restaurants("The Biriyani House", "Bangalore");
        Customer customer = new Customer("Rahul", "+91930304949",  "Whitefield");
        DeliveryPartner deliveryPartner = new DeliveryPartner("Ram", "+9120303030");

        Order order = new Order("orderId1", restaurant.getName(), customer.getName());
        order.addObserver(restaurant);
        order.addObserver(customer);
        order.addObserver(deliveryPartner);

        order.confirm();
        order.startPreparing();
        order.outForDelivery(deliveryPartner.getName());
        order.deliver();
        order.cancel("food is not good");
    }
}