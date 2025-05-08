import java.util.Scanner;

public class Main {
    private static int N, cnt;
    private static int[][] graph;
    private static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                graph[i][j] = sc.nextInt();

        int popCnt = 0, maxCnt = 0;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (!visited[i][j]){
                    visited[i][j]=true;
                    cnt = 1;
                    DFS(i,j);
                    if (cnt>=4) popCnt++;
                    maxCnt = Math.max(maxCnt,cnt);
                }
            }
        }
        System.out.println(popCnt+" "+maxCnt);
    }

    private static void DFS(int x, int y){
        for (int dir = 0; dir<4; dir++){
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if (!inRange(nx,ny)||visited[nx][ny]) continue;
            if (graph[nx][ny]!=graph[x][y]) continue;
            visited[nx][ny] = true;
            cnt++; // 블럭 크기
            DFS(nx,ny);
        }
    }
    public static boolean inRange(int x, int y){
        if (x>=0&&x<N&&y>=0&&y<N) return true;
        return false;
    }
}
