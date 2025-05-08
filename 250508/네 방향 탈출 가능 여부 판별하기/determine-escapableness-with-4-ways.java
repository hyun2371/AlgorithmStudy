import java.util.*;
public class Main {
    private static boolean[][] visited;
    private static int[][] graph;
    private static int N,M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                graph[i][j] = sc.nextInt();
        System.out.println(BFS(0,0));
    }

    private static int BFS(int x, int y){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x,y));
        visited[x][y] = true;

        while (!q.isEmpty()){
            Pos cur = q.poll();
            for (int d=0;d<4;d++){
                int nx = cur.x+dx[d];
                int ny = cur.y+dy[d];
                if (nx==N-1&&ny==M-1) return 1;
                if (!inRange(nx,ny)||visited[nx][ny]||graph[nx][ny]==0) continue;
                visited[nx][ny] = true;
                q.offer(new Pos(nx,ny));
            }
            
        }
        return 0;
    }

    private static boolean inRange(int x, int y){
        return x>=0&&x<N&&y>=0&&y<N;
    }
}

class Pos {
    int x;
    int y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}