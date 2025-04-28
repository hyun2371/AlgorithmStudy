import java.util.Scanner;

public class Main {
    private static int[] x,y;
    private static int N;
    public static void main(String[] args) {
        initCourse();
        
        int minTotalDis = Integer.MAX_VALUE;
        for (int ex = 1; ex<N-1;ex++){ // 제외 점
            int prev = 0, totalDis = 0;
            for (int cur = 0;cur<N;cur++){ // 방문 점
                if (cur==ex) continue;
                totalDis+=getDis(prev,cur);
                prev = cur;
            }
            minTotalDis = Math.min(totalDis,minTotalDis);
        }
        System.out.println(minTotalDis);
    }

    private static int getDis(int prev, int cur){
        return Math.abs(x[cur]-x[prev])+Math.abs(y[cur]-y[prev]);
    }

    private static void initCourse(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        x = new int[N];
        y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
    }
}
