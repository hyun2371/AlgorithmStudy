import java.util.*;
public class Main {
    static int[] dx ={-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static int N;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int r1 = sc.nextInt()-1;
        int c1 = sc.nextInt()-1;
        int r2 = sc.nextInt()-1;
        int c2 = sc.nextInt()-1;
        
        if (r1==r2&&c1==c2) {
            System.out.println(0); return;
        }
        graph = new int[N][N];
        for (int i =0;i<N;i++){
            Arrays.fill(graph[i],-1);
        }
         System.out.println(BFS(r1,c1,r2,c2));
    }

    private static int BFS(int r1, int c1, int r2, int c2){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(r1,c1));
        graph[r1][c1] = 0;

        while (!q.isEmpty()){
            Pos cur = q.poll();
            for (int d=0;d<8;d++){
                int nx = cur.x+dx[d];
                int ny = cur.y+dy[d];
                if (!inRange(nx,ny)||graph[nx][ny]!=-1) continue;
                graph[nx][ny] = graph[cur.x][cur.y]+1;
                q.offer(new Pos(nx,ny));
                if (nx==r2&&ny==c2) return graph[nx][ny];
            }
        }
        return -1;
    }

    private static boolean inRange(int x, int y){
        return x>=0&&y>=0&&x<N&&y<N;
    }
}

class Pos{
    int x, y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}