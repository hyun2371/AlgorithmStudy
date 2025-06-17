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
        boolean isNowUp = false;
        
        for (int i=0;i<n;i++){
            if (h[i]>limit) isNowUp = true;
            else isNowUp = false;
            
            if (isPrevUp&&!isNowUp){
                cnt++;
            }
            isPrevUp = isNowUp;
        }
        if (isPrevUp) cnt++;
        return cnt;
    }

}