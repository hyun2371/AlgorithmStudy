import java.util.*;
public class Main {
    private static int N,M;
    private static int[][] graph;
    private static boolean[][] visited;
    // 뱀 없음 1, 뱀 있음 0 방문함 0
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++)
                graph[i][j] = sc.nextInt();
        }     
        DFS(0,0);
        System.out.println(0);  
    }

    private static void DFS(int x, int y){
        if (x==N-1&&y==M-1) {
            System.out.println(1);
            System.exit(0);
        }
        if (!inRange(x,y)||visited[x][y]||graph[x][y]==0) return;
        visited[x][y] = true;
        DFS(x+1,y);
        DFS(x,y+1);
    }

    private static boolean inRange(int x, int y){
        return x>=0&&y>=0&&x<N&&y<M;
    }
}