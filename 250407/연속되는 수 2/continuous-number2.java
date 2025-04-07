import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int cnt = 0, answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (i==0||arr[i]==arr[i-1]) cnt++;
            else {
                answer = Math.max(cnt,answer);
                cnt=1;
            }

        }
        System.out.println(answer);
    }
}