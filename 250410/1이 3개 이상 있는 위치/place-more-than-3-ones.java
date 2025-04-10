import java.util.*;
public class Main {
    private static int n;
    public static void main(String[] args) {
        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        

        int answer = 0;
        for (int x=0;x<n;x++){
            for (int y=0;y<n;y++){
                int cnt=0;
                for (int d=0;d<4;d++){
                    int nx = x+dx[d];
                    int ny = y+dy[d];

                    if (isRange(nx,ny)&&arr[nx][ny]==1) cnt++;
                }
                if (cnt>=3) answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isRange(int x, int y){
        if (x<0||y<0||x>=n||y>=n) return false;
        return true;
    }
}