package org.kraabhi.Subject;

import org.kraabhi.Observers.Observer;
import org.kraabhi.model.OrderEvent;

public interface OrderSubjects {
     void addObserver(Observer obs);
     void removeObserver(Observer obs);
     void notify(OrderEvent event);
}
