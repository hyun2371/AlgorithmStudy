import java.util.*;

public class Main {
    private static final int MAX_T = 1_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] a = new int[MAX_T+1];
        int[] b = new int[MAX_T+1];

        int timeA =1, timeB = 1;

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            while (t-->0){
                if (d=='R')
                    a[timeA] = a[timeA-1]+1;
                else
                    a[timeA] = a[timeA-1]-1;
                timeA++;
            }
        }
  
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            while (t-->0){
                if (d=='R')
                    b[timeB] = b[timeB-1]+1;
                else
                    b[timeB] = b[timeB-1]-1;
                timeB++;
            }
        }
        
        boolean isSame= true;
        int cnt = 0;
        for (int i=1;i<Math.max(timeA,timeB);i++){
            if (i>=timeA) a[i] = a[i-1];
            if (i>=timeB) b[i] = b[i-1];
            if (a[i]==b[i]){
                if (!isSame) {
                    cnt++;
                }
                isSame = true;
            }
            else isSame= false;
        }
        System.out.println(cnt);
    }
}