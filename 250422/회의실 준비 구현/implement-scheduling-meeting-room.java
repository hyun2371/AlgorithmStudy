import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Schedule> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            lst.add(new Schedule(s,e));
        }
         Collections.sort(lst);
        

        int cnt = 0, prevEt = 0;
        for (Schedule cur : lst){
            if (cur.st>=prevEt){ // 현재 회의 시작 시간>=이전 회의 종료 시간
                prevEt = cur.et; // 현재 회의 종료시간 갱신
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}



class Schedule implements Comparable<Schedule>{
    int st;
    int et;

    public Schedule(int st, int et){
        this.st = st;
        this.et = et;
    }

    @Override
    public int compareTo(Schedule s){
        return this.et-s.et;//종료시간 오름차순 10 20
    }
}