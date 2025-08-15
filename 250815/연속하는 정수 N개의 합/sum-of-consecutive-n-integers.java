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
        int lt = 0, rt = lt+1, cnt = 0;
        int sum = arr[lt];

        while (lt<=rt){
            if (sum>=m){
                if (sum==m) cnt++;
                sum-=arr[lt++];
            } else {
                if (rt==n) break;
                sum+=arr[rt++];
            }
        }
        System.out.println(cnt);
    }
}