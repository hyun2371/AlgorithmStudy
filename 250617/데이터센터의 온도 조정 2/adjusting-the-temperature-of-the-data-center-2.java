import java.util.*;
public class Main {
    private static int N,C,G,H;
    private static int[] ta,tb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        G = sc.nextInt();
        H = sc.nextInt();
        ta = new int[N];
        tb = new int[N];
        int minLimit = Integer.MAX_VALUE;
        int maxLimit = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            ta[i] = sc.nextInt();
            tb[i] = sc.nextInt();
            minLimit = Math.min(minLimit,ta[i]);
            maxLimit = Math.max(maxLimit, tb[i]);
        }

        int maxTotalScore = 0;
        for (int num=minLimit-1;num<=maxLimit+1;num++){
            int totalScore = getTotalScore(num);
            maxTotalScore = Math.max(maxTotalScore, totalScore);
        }
        System.out.println(maxTotalScore);
    }

    private static int getTotalScore(int num){
        int totalScore = 0;
        for (int ind=0;ind<N;ind++){
            totalScore+=getScore(num,ta[ind],tb[ind]);
        }
        return totalScore;
    }

    private static int getScore(int num,int t1, int t2){
        if (num<t1) return C;
        if (num<=t2) return G;
        return H;
    }
}