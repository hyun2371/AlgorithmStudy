import java.util.Scanner;

public class Main {
    private static final int OFFSET = 100_000;
    private static final int LENGTH = 200_001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[] area = new char[LENGTH]; // 초기값 '\u0000' (널 문자)

        int cur = 0; // 현재 위치
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            int start, end;
            char paintColor;

            if (d == 'L') {
                start = cur - x + 1;
                end = cur;
                paintColor = 'W';
                cur = start; 
            } else {
                start = cur;
                end = cur + x - 1;
                paintColor = 'B';
                cur = end; 
            }

            // 칠하기
            for (int j = start + OFFSET; j <= end + OFFSET; j++) {
                area[j] = paintColor;
            }
        }

        int wCount = 0, bCount = 0;
        for (char c : area) {
            if (c == 'W') wCount++;
            else if (c == 'B') bCount++;
        }

        System.out.println(wCount + " " + bCount);
    }
}