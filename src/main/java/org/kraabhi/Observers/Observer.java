package org.kraabhi.Observers;

import org.kraabhi.model.OrderEvent;

public interface Observer {
    void onUpdate(OrderEvent orderEvent);
}
