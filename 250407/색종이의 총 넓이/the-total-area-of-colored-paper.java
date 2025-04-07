import java.util.Scanner;
public class Main {
    private static final int  OFFSET = 100;
    private static final int  LEN = 201;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] area = new boolean[LEN][LEN];
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt()+OFFSET;
            y[i] = sc.nextInt()+OFFSET;

            for (int r=x[i];r<x[i]+8;r++){
                for (int c=y[i];c<y[i]+8;c++){
                    area[r][c] = true;
                }
            }
        }
        int cnt = 0;
        for (int r= 0;r<LEN;r++){
            for (int c = 0;c<LEN;c++){
                if(area[r][c]) cnt++;
            }
        }
        System.out.println(cnt);
        // Please write your code here.
    }
}
