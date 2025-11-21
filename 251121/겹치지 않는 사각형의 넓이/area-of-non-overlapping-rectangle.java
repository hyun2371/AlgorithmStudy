import java.util.Scanner;
public class Main {
    static int OFFSET = 1000;
    static boolean[][] area = new boolean[2001][2001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax1 = sc.nextInt();
        int ay1 = sc.nextInt();
        int ax2 = sc.nextInt();
        int ay2 = sc.nextInt();
        int bx1 = sc.nextInt();
        int by1 = sc.nextInt();
        int bx2 = sc.nextInt();
        int by2 = sc.nextInt();
        int mx1 = sc.nextInt();
        int my1 = sc.nextInt();
        int mx2 = sc.nextInt();
        int my2 = sc.nextInt();
        // Please write your code here.
        color(ax1, ax2, ay1, ay2,true);
        color(bx1, bx2, by1, by2,true);
        color(mx1, mx2, my1, my2,false);
        int cnt = 0;
        for (int i=0;i<=2000;i++){
            for (int j=0;j<=2000;j++){
                if (area[i][j]) cnt++;
            }
        }
        System.out.print(cnt);
    }

    private static void color(int x1, int x2, int y1, int y2, boolean value){
        for (int i=x1+OFFSET;i<x2+OFFSET;i++){
            for (int j=y1+OFFSET;j<y2+OFFSET;j++){
                area[i][j] = value;
            }
        }
    }
}