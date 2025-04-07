import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int cnt=0, answer=0;
        
        for (int i=0;i<n;i++){
            if (arr[i]<=t) cnt=0;
            else if (i==0||arr[i]<=arr[i-1]) cnt=1;
            else cnt++;

            answer=Math.max(cnt,answer);
        }
        
        System.out.println(answer);
    }
}