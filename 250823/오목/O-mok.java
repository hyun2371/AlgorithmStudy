import java.util.Scanner;

public class Main {
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[19][19];

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j]==0) continue;
                for (int d=0;d<8;d++){
                    int cnt = 1;
                    int cx = i, cy = j;
                    while (true){
                        int nx = cx+dx[d];
                        int ny = cy+dy[d];
                        if (!inRange(nx,ny)) break;
                        if (arr[nx][ny]!=arr[i][j]) break;
                        cnt++;
                        cx = nx; cy = ny;
                    }
                    if (cnt==5){
                        System.out.println(arr[i][j]);
                        System.out.print((i+2*dx[d]+1)+" "+(j+2*dy[d]+1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static boolean inRange(int x, int y){
        return x>=0&&y>=0&&x<19&&y<19;
    }
}