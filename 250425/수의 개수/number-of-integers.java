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
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            System.out.println(upperBound(x)-lowerBound(x));
        }
    }

    private static int lowerBound(int target){
        int lt = 0, rt = N-1;
        int midIdx = N;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if (arr[mid]>=target){
                midIdx = Math.min(midIdx,mid);
                rt = mid-1;
            }
            else lt = mid+1;
        }
         return midIdx;
    }

    private static int upperBound(int target){
        int lt = 0, rt = N-1;
        int midIdx = N;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if (arr[mid]>target){
                midIdx = Math.min(midIdx,mid);
                rt = mid-1;
            }
            else lt = mid+1;
        }
        return midIdx;
    }

    
}