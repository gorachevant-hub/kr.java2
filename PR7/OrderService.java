public class OrderService {
 public Order createOrder(Employee employee){return new Order(employee);}
 public void validateForConfirm(Order order){if(order==null||order.getItems().isEmpty())throw new IllegalArgumentException("Пустой заказ");}
}
