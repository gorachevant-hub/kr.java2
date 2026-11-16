import java.time.LocalDate;
public class SelfCheck {
 public static void main(String[] args){
  Employee e=new Employee("1","Иван");BusinessTripService s=new BusinessTripService();
  BusinessTrip t=s.create("t1",e,LocalDate.of(2025,1,1),LocalDate.of(2025,1,3));
  try{t.approve();throw new AssertionError();}catch(IllegalStateException ok){}
  t.submit();t.approve();try{t.complete(LocalDate.of(2025,1,3));throw new AssertionError();}catch(IllegalArgumentException ok){}
  t.complete(LocalDate.of(2025,1,4));if(t.getStatus()!=TripStatus.COMPLETED)throw new AssertionError();
  try{t.cancel();throw new AssertionError();}catch(IllegalStateException ok){}
  BusinessTrip r=s.create("t2",e,LocalDate.of(2025,2,1),LocalDate.of(2025,2,2));r.submit();
  try{r.reject("коротко");throw new AssertionError();}catch(IllegalArgumentException ok){}
  r.reject("Причина отказа подробно");if(r.getStatus()!=TripStatus.REJECTED)throw new AssertionError();
  BusinessTrip c=s.create("t3",e,LocalDate.of(2025,3,1),LocalDate.of(2025,3,2));c.cancel();
  try{s.create("t4",e,LocalDate.of(2025,2,2),LocalDate.of(2025,2,1));throw new AssertionError();}catch(IllegalArgumentException ok){}
  try{s.create("t1",e,LocalDate.of(2025,1,1),LocalDate.of(2025,1,3));throw new AssertionError();}catch(IllegalArgumentException ok){}
  System.out.println("PR8 OK");
 }
}
