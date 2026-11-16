import java.util.*;
public final class Order {
 private final Employee employee;private final List<OrderItem> items=new ArrayList<>();private boolean confirmed;
 public Order(Employee employee){if(employee==null)throw new IllegalArgumentException("Сотрудник");this.employee=employee;}
 private void editable(){if(confirmed)throw new IllegalStateException("Заказ подтверждён");}
 public void addProduct(Product product,int quantity){editable();if(product==null||quantity<1||quantity>100)throw new IllegalArgumentException("Позиция");
  for(OrderItem i:items)if(i.getProduct().getId().equals(product.getId())){if(Double.compare(i.getProduct().getPrice(),product.getPrice())!=0)throw new IllegalArgumentException("Конфликт товара по id");i.increase(quantity);return;}
  items.add(new OrderItem(product,quantity));
 }
 public void removeProduct(String id){editable();if(id==null||!items.removeIf(i->i.getProduct().getId().equals(id)))throw new IllegalArgumentException("Товар не найден");}
 public double total(){double sum=0;for(OrderItem i:items)sum+=i.getLineTotal();return sum;}
 public void confirm(){editable();if(items.isEmpty())throw new IllegalStateException("Пустой заказ");confirmed=true;}
 public boolean isConfirmed(){return confirmed;}
 public List<OrderItem> getItems(){return Collections.unmodifiableList(items);}
 public Employee getEmployee(){return employee;}
}
