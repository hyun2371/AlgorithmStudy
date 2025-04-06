import java.util.Scanner;
public class Main {
    private static final int OFFSET = 100;
    private static final int LEGNTH=200;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] board = new boolean[LEGNTH+1][LEGNTH+1];
        int maxX=0, maxY=0;
        int n = sc.nextInt(); // 사각형 개수
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];

        for (int t = 0; t < n; t++) {
            x1[t] = sc.nextInt() + OFFSET;
            y1[t] = sc.nextInt()+OFFSET;
            x2[t] = sc.nextInt()+OFFSET;
            y2[t] = sc.nextInt()+OFFSET;   
            maxX = Math.max(x2[t],maxX);
            maxY = Math.max(y2[t],maxY);
            for (int i=x1[t];i<x2[t];i++){
                for (int j=y1[t];j<y2[t];j++){
                    board[i][j] = true;
                }
            }
        }
        int cnt=0;
        for (int i= 0;i<=maxX;i++){
            for (int j=0;j<maxY;j++){
                if (board[i][j]) cnt++;
            }
        }
        System.out.println(cnt);
    }
}