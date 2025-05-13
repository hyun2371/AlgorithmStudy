import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] d = new int[N+1];
        
        if (N==2) {
            System.out.println(1); return;
        }
        d[2] = 1; d[3]=1;
        for (int i=4;i<=N;i++){
            d[i] = Math.max(d[i-2],d[i-3])+1;
        }
        
        System.out.println(d[N]);
    }
}