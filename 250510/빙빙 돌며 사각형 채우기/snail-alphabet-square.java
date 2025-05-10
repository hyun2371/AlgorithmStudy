import java.util.Scanner;
public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static char[][] arr;
    static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        int dirNum = 0;
        char ch = 'A';
        
        int x = 0,y = 0;
        arr[x][y]=ch;
        visited[x][y] = true; 
        
        for (int i=2;i<=N*M;i++){
            int nx = x+dx[dirNum];
            int ny = y+dy[dirNum];      
            if (!inRange(nx,ny)||visited[nx][ny]){
                dirNum = (dirNum+1)%4;
                nx = x+dx[dirNum];
                ny = y+dy[dirNum];
            }  
            ch = (char)(ch+1); 
            arr[nx][ny] = ch;
            visited[nx][ny] = true;
            x = nx; y = ny;         
        }
        
        printAnswer(sc);
        
    }
    private static boolean inRange(int x, int y){
        return x>=0&&y>=0&&x<N&&y<M;
    }

    private static void printAnswer(Scanner sc){
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}