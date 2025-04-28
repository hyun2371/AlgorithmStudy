import java.util.Scanner;
public class Main {
    static int N,M;
    static char[][] arr;
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,-1,1,-1,1,1,-1};
    public static void main(String[] args) {
        initArr();

        int answer = 0;
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (arr[i][j]!='L') continue;
                for (int dirNum=0;dirNum<8;dirNum++){
                    int curX = i;
                    int curY = j;
                    int eCnt = 0;
                    while (true){
                        int nx = curX + dx[dirNum];
                        int ny = curY + dy[dirNum];
                        
                        if (!isRange(nx,ny)) break;
                        if (arr[nx][ny]!='E') break;
                        eCnt++; 
                        if (eCnt==2) {
                            answer++; break;
                        }
                        curX = nx; curY = ny;
                    }
                }
            }
        }
        
        System.out.println(answer);
    }

    private static boolean isRange(int x, int y){
        return x>=0&&y>=0&&x<N&&y<M;
    }

    private static void initArr(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j=0;j<M;j++){
                arr[i][j] = s.charAt(j);
            }
        }
    }
}