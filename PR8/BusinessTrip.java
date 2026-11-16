import java.time.LocalDate;
public final class BusinessTrip {
 private final String id;private final Employee employee;private final LocalDate start,end;
 private TripStatus status=TripStatus.DRAFT;private String rejectionReason;
 public BusinessTrip(String id,Employee employee,LocalDate start,LocalDate end){
  if(id==null||id.isBlank()||employee==null||start==null||end==null||end.isBefore(start))throw new IllegalArgumentException("Неверные данные командировки");
  this.id=id;this.employee=employee;this.start=start;this.end=end;
 }
 private void require(TripStatus expected){if(status!=expected)throw new IllegalStateException("Недопустимый переход из "+status);}
 public void submit(){require(TripStatus.DRAFT);status=TripStatus.SUBMITTED;}
 public void approve(){require(TripStatus.SUBMITTED);status=TripStatus.APPROVED;}
 public void reject(String reason){require(TripStatus.SUBMITTED);if(reason==null||reason.trim().length()<10)throw new IllegalArgumentException("Причина короче 10 символов");rejectionReason=reason.trim();status=TripStatus.REJECTED;}
 public void cancel(){if(status!=TripStatus.DRAFT&&status!=TripStatus.SUBMITTED&&status!=TripStatus.APPROVED)throw new IllegalStateException("Отмена невозможна");status=TripStatus.CANCELLED;}
 public void complete(LocalDate today){require(TripStatus.APPROVED);if(today==null||!today.isAfter(end))throw new IllegalArgumentException("Дата окончания ещё не прошла");status=TripStatus.COMPLETED;}
 public TripStatus getStatus(){return status;}public String getId(){return id;}public String getRejectionReason(){return rejectionReason;}
}
