import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i=0;i<n;i++){
            coin[i] = sc.nextInt();
        }
        int[] d = new int[m+1];
        Arrays.fill(d, 101);

        d[0] = 0;
        for (int i=1;i<=m;i++){
            for (int j=0;j<n;j++){
                if (i>=coin[j])
                    d[i] = Math.min(d[i],d[i-coin[j]]+1);
            }
        }
        int answer;
        if (d[m]==101) answer = -1;
        else answer = d[m];
        System.out.print(answer);
    }
}