import java.util.Scanner;
public class Main {
    private static int n,m;
    private static int[] dx= {0,1,0,-1};
    private static int[] dy= {1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //행
        m = sc.nextInt(); //열

        int[][] arr = new int[n][m];
        int dir = 0;
        int x=0,y=0; arr[0][0]=1;

        for (int i=2;i<=n*m;i++){
            int nx=x+dx[dir];
            int ny=y+dy[dir];
            if (!isRange(nx,ny)||arr[nx][ny]!=0){//범위 벗어나거나 이미 방문
                dir = (dir+1)%4;   
            } // ~검증
            x+=dx[dir]; y+=dy[dir];
            arr[x][y]=i;
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
    }

    private static boolean isRange(int x, int y){
        if (x<0||x>=n||y<0||y>=m) return false;
        return true;
    }
}