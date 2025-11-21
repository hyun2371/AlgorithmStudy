import java.util.*;

public class Main {
    static int LEN = 2000;
    static int minX=LEN, minY=LEN, maxX=0, maxY=0;
    static boolean[][] area = new boolean[LEN+1][LEN+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt();
        int rect1_y1 = sc.nextInt();
        int rect1_x2 = sc.nextInt();
        int rect1_y2 = sc.nextInt();
        int rect2_x1 = sc.nextInt();
        int rect2_y1 = sc.nextInt();
        int rect2_x2 = sc.nextInt();
        int rect2_y2 = sc.nextInt();
        // Please write your code here.

        color(rect1_x1, rect1_x2, rect1_y1, rect1_y2, true);
        color(rect2_x1, rect2_x2, rect2_y1, rect2_y2, false);
        
        for (int i=0;i<=LEN;i++){
            for (int j=0;j<=LEN;j++){
                if (area[i][j]) {
                    minX = Math.min(minX,i);
                    minY = Math.min(minY,j);
                    maxX = Math.max(maxX,i);
                    maxY = Math.max(maxY,j);
                }
            }
        }
        if (minX>maxX) System.out.print(0);
        else System.out.print((maxX-minX+1)*(maxY-minY+1));
    }

    private static void color(int x1, int x2, int y1, int y2, boolean value){
        int OFFSET = 1000;
        for (int i=x1+OFFSET;i<x2+OFFSET;i++){
            for (int j=y1+OFFSET;j<y2+OFFSET;j++){
                area[i][j] = value;
            }
        }
    }
}