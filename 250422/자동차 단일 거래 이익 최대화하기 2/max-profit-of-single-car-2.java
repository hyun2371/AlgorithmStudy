import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++)
            prices[i] = sc.nextInt();
        
        int min = Integer.MAX_VALUE; // 이전 숫자들 중 가장 작은 값 
        int ans = 0; // 현재까지 price-min의 최대값 => 최고 이익

        for (int price : prices){
            if (price>min){
                ans = Math.max(ans,price-min);
            }
            else {
                min = price;
            }
        }
        System.out.println(ans);
    }
}