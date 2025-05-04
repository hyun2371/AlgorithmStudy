import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int answer = Integer.MIN_VALUE;
        for (int i=0;i<=n-k;i++){ // n=6 k=3 -> i=0~n-4 // 0,2
            int sum = 0;
            for (int j=i;j<i+k;j++)
                sum+=arr[j];
            answer = Math.max(sum,answer);
        }
        System.out.println(answer);
    }
}