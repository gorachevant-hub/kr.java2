public class SelfCheck {
 public static void main(String[] args){
  Order o=new OrderService().createOrder(new Employee("e1","Иван"));Product p=new Product("p1","Монитор",100);
  o.addProduct(p,1);o.addProduct(p,2);if(o.getItems().size()!=1||o.total()!=300)throw new AssertionError();
  try{o.addProduct(p,98);throw new AssertionError();}catch(IllegalArgumentException ok){}
  try{o.getItems().clear();throw new AssertionError();}catch(UnsupportedOperationException ok){}
  o.confirm();try{o.removeProduct("p1");throw new AssertionError();}catch(IllegalStateException ok){}
  try{new Product("bad","",0);throw new AssertionError();}catch(IllegalArgumentException ok){}
  Order empty=new Order(new Employee("e2","Тест"));try{empty.confirm();throw new AssertionError();}catch(IllegalStateException ok){}
  Order boundary=new Order(new Employee("e3","Тест"));boundary.addProduct(p,100);if(boundary.total()!=10000)throw new AssertionError();
  try{boundary.addProduct(p,1);throw new AssertionError();}catch(IllegalArgumentException ok){}
  System.out.println("PR7 OK");
 }
}
