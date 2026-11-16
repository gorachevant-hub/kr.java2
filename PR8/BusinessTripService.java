import java.time.LocalDate;import java.util.*;
public class BusinessTripService {
 private final List<BusinessTrip> trips=new ArrayList<>();
 public BusinessTrip create(String id,Employee e,LocalDate start,LocalDate end){
  for(BusinessTrip t:trips)if(t.getId().equals(id))throw new IllegalArgumentException("Повторный id");
  BusinessTrip trip=new BusinessTrip(id,e,start,end);trips.add(trip);return trip;
 }
 public List<BusinessTrip> findByStatus(TripStatus status){if(status==null)throw new IllegalArgumentException("Статус");List<BusinessTrip> out=new ArrayList<>();for(BusinessTrip t:trips)if(t.getStatus()==status)out.add(t);return Collections.unmodifiableList(out);}
}
