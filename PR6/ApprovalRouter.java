public class ApprovalRouter {
 public static final long FINANCE_LIMIT = 500_000L;
 public static ApprovalRoute route(long amount, boolean urgent, RiskLevel risk, boolean personal){
  if(amount<0 || risk==null)throw new IllegalArgumentException("Неверные параметры заявки");
  if(personal)return ApprovalRoute.SECURITY_REVIEW;
  if(risk==RiskLevel.HIGH)return ApprovalRoute.DIRECTOR_REVIEW;
  if(amount>=FINANCE_LIMIT)return ApprovalRoute.FINANCE_REVIEW;
  if(urgent)return ApprovalRoute.FAST_TRACK;
  return ApprovalRoute.STANDARD;
 }
 public static void main(String[] args){System.out.println(route(499999,true,RiskLevel.LOW,false));}
}
