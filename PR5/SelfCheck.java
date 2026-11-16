public class SelfCheck {
 static void bad(String s){try{TimesheetAnalyzer.parseHours(s);throw new AssertionError("Expected error: "+s);}catch(IllegalArgumentException ok){}}
 public static void main(String[] args){
  assert TimesheetAnalyzer.total(TimesheetAnalyzer.parseHours("8;9;8;7;10"))==42;
  assert TimesheetAnalyzer.weeklyOvertime(TimesheetAnalyzer.parseHours("8;9;8;7;10"))==2;
  assert TimesheetAnalyzer.total(TimesheetAnalyzer.parseHours("0;0;0;0;0"))==0;
  assert TimesheetAnalyzer.total(TimesheetAnalyzer.parseHours("16;16;16;16;16"))==80;
  bad("");bad("1;2;3;4;17");bad("1;2;x;4;5");bad("1;2;3;4");bad("1;2;;4;5");bad("1;2;3;4;-1");bad("1;2;3;4;16.5");bad("1;2;3;4;5;");
  System.out.println("PR5 OK");
 }
}
