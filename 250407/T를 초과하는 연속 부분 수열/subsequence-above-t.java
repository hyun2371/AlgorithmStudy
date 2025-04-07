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
            if (arr[i]<=t) cnt=0; //t보다 작은수
            else cnt++; //t보다 큼

            answer=Math.max(cnt,answer);
        }
        
        System.out.println(answer);
    }
}