public final class Employee {
 private final String id,fullName;
 public Employee(String id,String fullName){if(id==null||id.isBlank()||fullName==null||fullName.isBlank())throw new IllegalArgumentException("Сотрудник");this.id=id;this.fullName=fullName;}
 public String getId(){return id;}
}
