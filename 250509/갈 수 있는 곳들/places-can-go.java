import java.util.*;
public class Main {
    static int N, cnt;
    static int[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int K = sc.nextInt();
        graph = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                graph[i][j] = sc.nextInt(); //0: 이동, 1: 이동 불가
            }
        }

        for (int i = 0; i < K; i++) {
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            if (graph[r][c]==0) BFS(r,c);
        }
        System.out.println(cnt);
    }

    private static void BFS(int x, int y){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x,y));
        graph[x][y] = 1;
        cnt++;
        while (!q.isEmpty()){
            Pos cur = q.poll();
            for (int d = 0; d<4;d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (!inRange(nx,ny)||graph[nx][ny]==1) continue;
                graph[nx][ny]=1;
                q.offer(new Pos(nx,ny));
                cnt++;
            } 
        } 
    }

    private static boolean inRange(int x, int y){
        return x>=0&&y>=0&&x<N&&y<N;
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