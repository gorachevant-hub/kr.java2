public final class OrderItem {
 private final Product product;private int quantity;
 public OrderItem(Product product,int quantity){if(product==null||quantity<1||quantity>100)throw new IllegalArgumentException("Позиция");this.product=product;this.quantity=quantity;}
 public Product getProduct(){return product;}public int getQuantity(){return quantity;}
 public double getLineTotal(){return product.getPrice()*quantity;}
 void increase(int extra){if(extra<1||quantity+extra>100)throw new IllegalArgumentException("Количество больше 100");quantity+=extra;}
}
