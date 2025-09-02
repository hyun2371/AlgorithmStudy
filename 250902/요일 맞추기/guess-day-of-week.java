import java.util.*;
public class Main {
    static int[] days= {
        0,31,28,31,30,31,30,31,31,30,31,30,31
    };
    static Map<Integer, String> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        int td1 = getTotalDays(m1,d1);
        int td2 = getTotalDays(m2,d2);
        
        initMap();
        int gap = (td2-td1)%7;
        gap = gap>=0?gap:gap+7;
        
        System.out.println(map.get(gap));
    }

    private static int getTotalDays(int m, int d){
        int totalDays = d;
        for (int i=1;i<m;i++){
            totalDays +=days[i];
        }
        return totalDays;
    }

    private static void initMap(){
        map.put(0,"Mon");
        map.put(1,"Tue");
        map.put(2,"Wed");
        map.put(3,"Thu");
        map.put(4,"Fri");
        map.put(5,"Sat");
        map.put(6,"Sun");
    }
}