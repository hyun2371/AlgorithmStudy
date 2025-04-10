import java.util.*;
public class Main {
    private static int n;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {-1,1,0,0};
    private static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int answer = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (adjCnt(i,j)>=3) answer++;
            }
        }
        System.out.println(answer);
    }

    private static int adjCnt(int x, int y){
        int cnt=0;
        for (int d=0;d<4;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];

            if (isRange(nx,ny)&&arr[nx][ny]==1) cnt++;
        }
        return cnt;
    }

    private static boolean isRange(int x, int y){
        if (x<0||y<0||x>=n||y>=n) return false;
        return true;
    }
}