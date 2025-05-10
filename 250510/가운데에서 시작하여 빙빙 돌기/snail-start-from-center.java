import java.util.*;

public class Main {
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int[][] arr;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        int x = N/2, y = N/2,dirNum=0, cnt = 1, nx,ny;
        arr[x][y] = cnt++;
        
        int moveNum = 1;
        while (true){
            for (int i=0;i<moveNum;i++){
                nx = x+dx[dirNum];
                ny = y+dy[dirNum];
                if (!inRange(nx,ny)||arr[nx][ny]!=0){
                    printAnswer(); System.exit(0);
                }
                arr[nx][ny] = cnt++;
                x = nx; y = ny;
            }
            
            dirNum = (dirNum+1)%4;
            if (dirNum==0||dirNum==2) moveNum++; //수평 방향 시 이동 횟수 증가
        }

    }

    private static boolean inRange(int x, int y){
        return x>=0&&y>=0&&x<N&&y<N;
    }

    private static void printAnswer(){
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}