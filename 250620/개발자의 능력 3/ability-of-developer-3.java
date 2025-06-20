import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];

        int sum =0;
        for (int i = 0; i < 6; i++) {
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i=0;i<6;i++){
            for (int j=i+1;j<6;j++){
                for (int k=j+1;k<6;k++){
                    int divSum1 = arr[i]+arr[j]+arr[k];
                    int divSum2 = sum-divSum1;
                    int diff = Math.abs(divSum1-divSum2);
                    minDiff = Math.min(minDiff,diff);
                }
            }
        }
        System.out.println(minDiff);
    }


}