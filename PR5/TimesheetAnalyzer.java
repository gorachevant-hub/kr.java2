public class TimesheetAnalyzer {
    public static final int DAILY_LIMIT = 16; // variant 5: upper bound; see README
    public static int[] parseHours(String input) {
        if (input == null) throw new IllegalArgumentException("Строка отсутствует");
        String[] parts = input.split(";", -1);
        if (parts.length != 5) throw new IllegalArgumentException("Нужно ровно 5 значений");
        int[] hours = new int[5];
        for (int i = 0; i < parts.length; i++) {
            try { hours[i] = Integer.parseInt(parts[i].trim()); }
            catch (NumberFormatException e) { throw new IllegalArgumentException("Неверное число в позиции " + (i + 1)); }
            if (hours[i] < 0 || hours[i] > DAILY_LIMIT) throw new IllegalArgumentException("Часы вне диапазона в позиции " + (i + 1));
        }
        return hours;
    }
    public static int total(int[] h) { int s=0; for(int x:h) s+=x; return s; }
    public static double average(int[] h) { return total(h)/(double)h.length; }
    public static int overtimeDays(int[] h) { int c=0; for(int x:h) if(x>8)c++; return c; }
    public static int weeklyOvertime(int[] h) { return Math.max(0,total(h)-40); }
    public static void main(String[] args) {
        try { int[] h=parseHours(args.length>0?args[0]:"8;9;8;7;10");
            System.out.printf("Сумма: %d, среднее: %.2f, дней > 8: %d, сверх 40: %d%n",total(h),average(h),overtimeDays(h),weeklyOvertime(h));
        } catch(IllegalArgumentException e){System.err.println(e.getMessage());}
    }
}
