import java.util.*;
public class Main {
    static int MAX_LEN = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[MAX_LEN+1];
        int maxPos = 0;
        for (int i = 0; i < n; i++) {
            int cnt = sc.nextInt();
            int pos = sc.nextInt();
            arr[pos] += cnt;
            maxPos = Math.max(maxPos, pos);
        }

        int maxTotal=0;
        for (int i=0;i<=maxPos;i++){
            int total=0;
            for (int j=i-k;j<=i+k;j++){
                if (j>=0&&j<=maxPos)
                    total+=arr[j];
            }
            maxTotal = Math.max(total,maxTotal);

        }
        System.out.println(maxTotal);
       
    }
    
}