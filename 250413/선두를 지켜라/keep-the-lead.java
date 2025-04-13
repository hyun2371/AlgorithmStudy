import java.util.Scanner;

public class Main {
    private static final int MAX_L = 1_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v,t,time=1;

        int[] aPos = new int[MAX_L+1];
        for (int i = 0; i < n; i++) {
            v = sc.nextInt();
            t = sc.nextInt();

            while (t-->0){
                aPos[time] = aPos[time-1]+v;
                time++;
            }
        }

        time = 1;
        int[] bPos = new int[MAX_L+1];
        for (int i = 0; i < m; i++) {
            v = sc.nextInt();
            t = sc.nextInt();

            while (t-->0){
                bPos[time] = bPos[time-1]+v;
                time++;
            }
        }
        
        int cnt = 0;
        char winner = '0';
        for (int i=1;i<time;i++){
            if (aPos[i]>bPos[i]){
                if (winner=='b')  cnt++;
                winner='a';
            }
            else if (aPos[i]<bPos[i]){
                if (winner=='a') cnt++;
                winner='b';
            }
        }

        System.out.println(cnt);
    }
}