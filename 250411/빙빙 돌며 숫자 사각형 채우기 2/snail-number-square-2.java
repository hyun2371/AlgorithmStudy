import java.util.Scanner;
public class Main {
    private static int n,m;
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        
        int x =0, y=0, dirNum = 0;
        arr[0][0]=1;

        for (int i=2;i<=n*m;i++){
            int nx = x+dx[dirNum];
            int ny = y+dy[dirNum];
            if (!inRange(nx,ny)||arr[nx][ny]!=0){
                dirNum = (dirNum+1)%4;
                nx = x+dx[dirNum];
                ny = y+dy[dirNum];
            }
            arr[nx][ny] = i;
            x= nx;
            y = ny;
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean inRange(int x, int y){
        return x>=0&&y>=0&&x<n&&y<m;
    }
}