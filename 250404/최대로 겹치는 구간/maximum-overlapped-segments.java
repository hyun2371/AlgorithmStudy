import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        int[] arr = new int[201];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt()+100;
            x2[i] = sc.nextInt()+100;

            for (int j=x1[i];j<x2[i];j++){
                arr[j]++;
            }
        }
        Arrays.sort(arr);
        System.out.println(arr[200]);
    }
}