import java.util.Scanner;

public class Main {
    private static int[] dx= {0,-1,1,0}; //좌 상 하 우
    private static int[] dy= {-1,0,0,1};
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // n행 n열
        int[][] arr = new int[N+1][N+1];

        int T = sc.nextInt(); //초
        int R = sc.nextInt(); //R행
        int C = sc.nextInt(); //C열
        char D = sc.next().charAt(0); //방향
        
        int dir = getDir(D);
        int x = R-1, y = C-1;
  
        for (int i=0;i<T;i++){
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if (!isRange(nx,ny)) {
                dir = 3-dir;
                continue;
            }
            x=nx;
            y=ny;
        }
        
        System.out.println((x+1)+" "+(y+1));
    }

    private static boolean isRange(int x, int y){
        if (x<0||y<0||x>=N||y>=N) return false;
        return true;
    }

    private static int getDir(char D){
        if (D=='L') return 0;
        if (D=='U') return 1;
        if (D=='D') return 2;
        else return 3;
    }
}