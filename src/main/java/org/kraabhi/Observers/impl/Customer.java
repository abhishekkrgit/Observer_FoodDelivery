package org.kraabhi.Observers.impl;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.kraabhi.Observers.Observer;
import org.kraabhi.model.OrderEvent;

@Slf4j
@Data
public class Customer implements Observer {
    private String name;
    private String address;
    private String phoneNo;

    public Customer(String name, String phoneNo, String address) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    @Override
    public void onUpdate(OrderEvent orderEvent) {
        log.info("[CustomerApp] name={} phoneno: {} status={} with message : {}", name, phoneNo, orderEvent.getStatus().toString(), orderEvent.getMessage());
    }
}
