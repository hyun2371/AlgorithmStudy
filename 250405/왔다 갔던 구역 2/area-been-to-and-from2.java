import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] area = new int[2001];
        int cur = 1000;
        char prevDir=' ';
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            if (dir ==prevDir){
                if (dir=='L') cur = cur-1;
                if (dir=='R') cur = cur+1;
            }
            if (dir=='R'){
                for (int ind = cur;ind<=cur+x-1;ind++){
                    area[ind]++;
                }
                cur = cur+x-1;
            } else {
                for (int ind = cur;ind>=cur-x+1;ind--){
                    area[ind]++;
                }
                cur = cur-x+1;
            }
            prevDir = dir;
        }
        
        int cnt = 0;
        for (int i=0;i<=2000;i++){
            if (area[i]>=2) cnt++;
        }
        System.out.println(cnt);
        
    }
}