import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] d = new int[m+1];
        Arrays.fill(d,100_000);
        d[0] = 0;
        for (int i=0;i<n;i++){
            for (int j=m;j>=1;j--){
                if (j>=arr[i])
                    d[j] = Math.min(d[j],d[j-arr[i]]+1);
            }
        }
        if (d[m]==100_000) d[m] = -1;
        System.out.println(d[m]);
    }
}