package org.kraabhi.Observers.impl;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.kraabhi.Observers.Observer;
import org.kraabhi.model.OrderEvent;

@Slf4j
@Data
public class DeliveryPartner implements Observer {
    private String name;
    private String phoneNo;

    public DeliveryPartner(String name, String phoneNo){
        this.name = name;
        this.phoneNo = phoneNo;
    }

    @Override
    public void onUpdate(OrderEvent orderEvent) {
        log.info("[DeliveryPartnerApp] name={} phoneno: {} status={} with message : {}",
                name,
                phoneNo,
                orderEvent.getStatus().toString(),
                orderEvent.getMessage());
    }

}
