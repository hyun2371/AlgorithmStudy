import java.util.*;
public class Main {
    private static int C,G,H;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        C = sc.nextInt();
        G = sc.nextInt();
        H = sc.nextInt();
        int[] ta = new int[n];
        int[] tb = new int[n];
        int minLimit = Integer.MAX_VALUE;
        int maxLimit = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ta[i] = sc.nextInt();
            tb[i] = sc.nextInt();
            minLimit = Math.min(minLimit,ta[i]);
            maxLimit = Math.max(maxLimit, tb[i]);
        }

        int maxScore = 0;
        for (int i=minLimit-1;i<=maxLimit+1;i++){
            int score = 0;
            for (int j=0;j<n;j++){
                score+=getScore(i,ta[j],tb[j]);
            }
            maxScore = Math.max(maxScore, score);
        }
        System.out.println(maxScore);
    }

    private static int getScore(int num,int t1, int t2){
        if (num<t1) return C;
        if (num<=t2) return G;
        return H;
    }
}