import java.util.Scanner;

public class Main {
    static int N;
    static String cmds;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0, -1,0,1};
    static int[][] arr = new int[N][N];
    public static void main(String[] args) {
        
        initArr();
        int dirNum = 0, score = 0;
        int x = N/2; int y = N/2;
        score+=arr[x][y];
        
        for (char cmd : cmds.toCharArray()){
            if (cmd=='L'){
                dirNum = (dirNum+1)%4;
            }
            else if (cmd=='R'){
                dirNum = (dirNum+3)%4;
            }
            else { // cmd == 'F'
                int nx = x + dx[dirNum];
                int ny = y + dy[dirNum];
                if (inRange(nx,ny)){
                    score+=arr[nx][ny];
                    x = nx; y=ny;
                }
            }
        }
        
        System.out.println(score);
    }

    private static void initArr(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int t = sc.nextInt();
        cmds = sc.next();
        arr = new int[N][N];
       

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x>=0&&y>=0&&x<N&&y<N;
    }
}