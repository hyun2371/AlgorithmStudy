import java.util.Scanner;

public class Main {
    private static final int MAX_L = 1_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v,t,aTime=1,bTime=1;

        int[] aPos = new int[MAX_L+1];
        for (int i = 0; i < n; i++) {
            v = sc.nextInt();
            t = sc.nextInt();

            while (t-->0){
                aPos[aTime] = aPos[aTime-1]+v;
                aTime++;
            }
        }

        int[] bPos = new int[MAX_L+1];
        for (int i = 0; i < m; i++) {
            v = sc.nextInt();
            t = sc.nextInt();

            while (t-->0){
                bPos[bTime] = bPos[bTime-1]+v;
                bTime++;
            }
        }
        
        int cnt = 0;
        char winner = '0';
        for (int i=1;i<aTime;i++){
            if (winner=='0'){
                if (aPos[i]>bPos[i]) winner = 'a';
                else if (aPos[i]<bPos[i]) winner = 'b';
            } 
            else if (winner=='b'){
                if (aPos[i]>bPos[i]) {
                    winner='a';
                    cnt++;
                }
            }
            else if (winner=='a') {
                if (aPos[i]<bPos[i]){
                    winner='b';
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}