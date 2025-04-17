import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 합
        int L = sc.nextInt(); // 최소 길이

        for (int k = L; k <= 100; k++) {
            int numerator = 2 * N - k * (k - 1);
            int denominator = 2 * k;

            if (numerator < 0) continue;
            if (numerator % denominator != 0) continue;

            int x = numerator / denominator;

            for (int i = 0; i < k; i++) {
                System.out.print((x + i) + " ");
            }
            return;
        }

        System.out.println("-1");
    }
}