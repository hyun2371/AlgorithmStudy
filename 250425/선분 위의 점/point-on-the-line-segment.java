import java.util.*;

public class Main {
    static int N;
    static int[] points;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 점 개수
        int M = sc.nextInt(); //선분 개수
        points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = sc.nextInt();
        }
        Arrays.sort(points);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int lb = lowerBound(s);
            int ub = upperBound(e);
            
            sb.append(ub-lb).append("\n");
        }
        System.out.println(sb);
    }

    private static int lowerBound(int target){ // target 이상인 arr[mid] 중 mid 최초값
        int lt =0, rt = N-1;
        int minIdx = N;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if (points[mid]>=target){
                minIdx = Math.min(mid,minIdx);
                rt = mid-1; // 더 작은게 있는지 탐색
            }
            else lt = mid+1;
        }
        return minIdx;
    }

    private static int upperBound(int target){ // target 초과인 arr[mid] 중 mid 최초값
        int lt =0, rt = N-1;
        int minIdx = N;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if (points[mid]>target){
                minIdx = Math.min(mid,minIdx);
                rt = mid-1; // 더 작은게 있는지 탐색
            }
            else lt = mid+1;
        }
        return minIdx;
    }
}