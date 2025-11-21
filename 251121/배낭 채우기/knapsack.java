import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        
        int[][] d = new int[n][m+1];// i번째 보석 까지 고려, 무게 j일 때 최대 무게
        for(int i=0;i<n;i++){
            Arrays.fill(d[i],Integer.MIN_VALUE);
        }
        d[0][0] = 0;
        d[0][w[0]] = v[0];
        for (int i=1;i<n;i++){
            for (int j=1;j<=m;j++){
                if (j>=w[i])
                    d[i][j] = Math.max(d[i-1][j],d[i-1][j-w[i]]+v[i]);
                else d[i][j] = d[i-1][j];
            }
            
        }

        int answer = 0;
        for (int i=1;i<=m;i++){
            answer = Math.max(answer,d[n-1][i]);
        }
        System.out.print(answer);
    }
}