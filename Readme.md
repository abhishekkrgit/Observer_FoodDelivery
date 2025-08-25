# Order Tracking – Observer Pattern

This example models an order lifecycle (food delivery style) using the **Observer** design pattern.  
Observers (Restaurant, Customer, DeliveryPartner) subscribe to `Order` updates and get notified via `onUpdate(OrderEvent)`.

## Class Diagram (renders on GitHub)

```mermaid
classDiagram
class OrderStatus {
  <<enumeration>>
  PENDING
  CONFIRMED
  PREPARING
  OUT_FOR_DELIVERY
  DELIVERED
  CANCELED
}

class OrderEvent {
  +status: OrderStatus
  +orderId: String
  +timestamp: Instant
  +message: String
  +eta: Duration
}

class Observer {
  <<interface>>
  +onUpdate(e: OrderEvent): void
}

class Order {
  -orderId: String
  -status: OrderStatus
  -timestamp: Instant
  -observers: List~Observer~
  +addObserver(o: Observer): void
  +removeObserver(o: Observer): void
  +notifyObservers(e: OrderEvent): void
  +confirm(): void
  +startPreparing(): void
  +outForDelivery(rider: String): void
  +deliver(): void
  +cancel(reason: String): void
}

class Restaurant {
  -name: String
  -location: String
  +onUpdate(e: OrderEvent): void
}

class Customer {
  -name: String
  -address: String
  -phoneNo: String
  +onUpdate(e: OrderEvent): void
}

class DeliveryPartner {
  -name: String
  -phoneNo: String
  +onUpdate(e: OrderEvent): void
}

Observer <|.. Restaurant
Observer <|.. Customer
Observer <|.. DeliveryPartner
Order "1" o-- "*" Observer
