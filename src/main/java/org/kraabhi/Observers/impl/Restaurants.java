package org.kraabhi.Observers.impl;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.kraabhi.Observers.Observer;
import org.kraabhi.model.OrderEvent;

@Slf4j
@Data
public class Restaurants implements Observer {
    private String name;
    private  String location;

    public Restaurants(String name, String location){
        this.name = name;
        this.location = location;
    }

    @Override
    public  void onUpdate(OrderEvent orderEvent) {
        log.info("[DeliveryPartnerApp] name={} status={} at Time: {}, with message : {}", name, orderEvent.getStatus().toString(), orderEvent.getTimeStamp(), orderEvent.getMessage());
    }

}
