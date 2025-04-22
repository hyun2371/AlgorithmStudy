import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        // Please write your code here.
        int sum = 0;
        for (int i=0;i<N;i++){
            if (sum<0) sum=a[i];
            else sum+=a[i];
        }
        System.out.println(sum);
    }
}