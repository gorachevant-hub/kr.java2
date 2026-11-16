public class SelfCheck {
 static void check(ApprovalRoute expected,long amount,boolean urgent,RiskLevel risk,boolean personal){
  if(ApprovalRouter.route(amount,urgent,risk,personal)!=expected)throw new AssertionError();
 }
 public static void main(String[] args){
  check(ApprovalRoute.SECURITY_REVIEW,1,true,RiskLevel.HIGH,true);
  check(ApprovalRoute.DIRECTOR_REVIEW,600000,true,RiskLevel.HIGH,false);
  check(ApprovalRoute.FINANCE_REVIEW,500000,true,RiskLevel.LOW,false);
  check(ApprovalRoute.FINANCE_REVIEW,500001,false,RiskLevel.MEDIUM,false);
  check(ApprovalRoute.FAST_TRACK,499999,true,RiskLevel.LOW,false);
  check(ApprovalRoute.STANDARD,499999,false,RiskLevel.LOW,false);
  check(ApprovalRoute.STANDARD,0,false,RiskLevel.MEDIUM,false);
  check(ApprovalRoute.SECURITY_REVIEW,0,false,RiskLevel.LOW,true);
  try{ApprovalRouter.route(-1,false,RiskLevel.LOW,false);throw new AssertionError();}catch(IllegalArgumentException ok){}
  try{ApprovalRouter.route(0,false,null,false);throw new AssertionError();}catch(IllegalArgumentException ok){}
  System.out.println("PR6 OK");
 }
}
