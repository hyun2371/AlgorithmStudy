import java.util.Scanner;

public class Main {
    static final int LEN = 19;
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1,-1};
    static int[][] arr;
    static int midX, midY;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[LEN][LEN];
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        for (int i=0;i<LEN;i++){
            for (int j=0;j<LEN;j++){
                int winner = findWinner(i,j);
                if (winner!=0) {
                    System.out.println(winner);
                    System.out.println(midX+" "+midY);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
    private static boolean isRange(int x, int y){
        return x>=0&&y>=0&&x<LEN&&y<LEN;
    }

    private static int findWinner(int x, int y){
        for (int d =0;d<8;d++){
            int cnt = 1;
            int curX = x, curY = y;
            while (true){
                int nx = curX+dx[d];
                int ny = curY+dy[d];
                if (!isRange(nx,ny))break;
                if (arr[nx][ny]!=arr[x][y]) break;

                cnt++;
                if (cnt==5) {
                    midX = x + dx[d]*2 +1;
                    midY = y + dy[d]*2+1;
                    return arr[nx][ny];
                }
                curX = nx; curY = ny;
            }
        }
        return 0;
    }
}