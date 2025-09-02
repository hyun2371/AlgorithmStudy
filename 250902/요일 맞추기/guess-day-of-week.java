import java.util.*;
public class Main {
    static int[] days= {
        0,31,28,31,30,31,30,31,31,30,31,30,31
    };
    static String[] dow = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    static Map<Integer, String> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        
        int gap = getTotalDays(m2,d2)-getTotalDays(m1,d1);

        while (gap<0){
            gap+=7;
        }
        System.out.println(dow[gap%7]);
    }

    private static int getTotalDays(int m, int d){
        int totalDays = d;
        for (int i=1;i<m;i++){
            totalDays +=days[i];
        }
        return totalDays;
    }

}