import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        int[] arr = new int[101];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
            for (int j=start[i];j<=end[i];j++){
                arr[j]++;
                if (arr[j]>max) max = arr[j];
            }
        }
        System.out.println(max);
    }
}