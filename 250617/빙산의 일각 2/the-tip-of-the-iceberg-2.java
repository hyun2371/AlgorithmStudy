import java.util.*;
public class Main {
    static int[] h;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = new int[n];

        int minRange = Integer.MAX_VALUE;
        int maxRange = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            minRange = Math.min(minRange,h[i]);
            maxRange = Math.max(maxRange, h[i]);
        }

        int maxCnt = 0;
        for (int limit = minRange;limit<maxRange;limit++){
            maxCnt = Math.max(maxCnt, getCnt(limit));
        }

        System.out.println(maxCnt);
    }

    static int getCnt(int limit){
        int cnt = 0;
        boolean isPrevUp = false;
        for (int i=0;i<n;i++){
            // 예전에 잠기지 않음& 지금 잠김
            if (isPrevUp&&h[i]<=limit){
                cnt++;
            }
            if (h[i]>limit) isPrevUp = true;
            else isPrevUp = false;
        }
        if (isPrevUp) cnt++;
        return cnt;
    }

}