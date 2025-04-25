import java.util.Scanner;
public class Main {
    static int[] arr;
    static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            sb.append(ps(target)).append("\n");
        }
        System.out.println(sb);
    }

    private static int ps(int target){
        int lt = 0, rt = N-1;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if (arr[mid]<target) lt = mid+1;
            else if (arr[mid]>target) rt = mid-1;
            else return mid+1;
        }
        return -1;
    }
}