import java.util.Scanner;
public class Main {
    static int n;
    static int[][] arr;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 크기
        int m = sc.nextInt(); // 개수
        StringBuffer sb = new StringBuffer();
        arr = new int[n][n];
        for (int i=0;i<m;i++){
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            arr[x][y] = 1;
            if (isSafe(x,y)) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isSafe(int x, int y){
        int cnt = 0;
        for (int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (inRange(nx,ny)&&arr[nx][ny]==1) cnt++;
        }
        return cnt==3;
    }
    private static boolean inRange(int x, int y){
        if (x<0||y<0||x>=n||y>=n) return false;
        return true;
    }
}