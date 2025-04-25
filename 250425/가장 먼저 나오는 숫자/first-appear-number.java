import java.util.Scanner;
public class Main {
    private static int N;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] queries = new int[M];
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            int lo = lowerBound(target);
            if (arr[lo]==target)
                System.out.println(lo+1);
            else System.out.println(-1);
        }
        // Please write your code here.
    }

    private static int lowerBound(int target){
        int lt = 0, rt = N-1;
        int minIdx = N-1;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if (arr[mid]>=target){
                rt = mid-1;
                minIdx = Math.min(mid, minIdx);
            }
            else lt = mid+1;
        }
        return minIdx;
    }
}