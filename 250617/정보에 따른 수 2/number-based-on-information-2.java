import java.util.*;
public class Main {
    static int minDis1,minDis2;
    static List<Pos> lst = new ArrayList<>();
    static int[][] pos;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < T; i++) {
            char alpha = sc.next().charAt(0);
            int x = sc.nextInt();
            lst.add(new Pos(alpha,x));
        }

        int cnt = 0;
        for (int k=a;k<=b;k++){
            getDis(k);
            if (minDis1<=minDis2)cnt++;
        }
        System.out.println(cnt);
        
        
    }

    private static void getDis(int k){
        minDis1 = Integer.MAX_VALUE;
        minDis2 = Integer.MAX_VALUE;
        for (int i=0;i<lst.size();i++){
            Pos p = lst.get(i);
            if (p.alpha=='S'){
                int dis1 = Math.abs(p.x-k);
                minDis1 = Math.min(minDis1, dis1);
               
            } else{
                int dis2 = Math.abs(p.x-k);
                minDis2 = Math.min(minDis2, dis2);
            }
        }
        
    }
}

class Pos implements Comparable<Pos>{
    char alpha;
    int x;

    public Pos(char alpha,int x){
        this.alpha = alpha;
        this.x = x;
    }

    public int compareTo(Pos e){
        return this.x-e.x;
    }
}