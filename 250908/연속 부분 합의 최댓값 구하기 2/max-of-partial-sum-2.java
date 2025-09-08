import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        
        int sum =0, answer = Integer.MIN_VALUE;
        for (int i=0;i<N;i++){
            sum+=a[i];
            if (sum<0) sum = a[i];
            answer = Math.max(answer,sum);
        }
        System.out.println(answer);
    }
}