import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];

        d[1] = 1; 
        if (n==1) {
            System.out.println(d[1]); return;
        }
        d[2] = 2;
        for (int i=3;i<=5;i++){
            d[i] = d[i-1]+d[i-2];
            if (i==5) d[i]++;
        }

        for (int i=6;i<=n;i++){
            d[i] = d[i-5]+d[i-2]+d[i-1];
        }
        System.out.println(d[n]);
    }
}