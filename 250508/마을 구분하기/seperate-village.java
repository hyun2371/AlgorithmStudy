import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,pCnt;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[N][N];
        List<Integer> pCnts = new ArrayList<>();
        int vCnt=0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                graph[i][j] = sc.nextInt(); // 사람:1, 장애물, 방문:0
        
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (graph[i][j]==1){
                    pCnt = 1;
                    DFS(i,j);
                    pCnts.add(pCnt);
                    vCnt++;
                } 
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(vCnt).append("\n");
        Collections.sort(pCnts);
        for (int c : pCnts){
            sb.append(c).append("\n");
        }       
        System.out.println(sb);        
    }

    private static void DFS(int x, int y){
        graph[x][y] = 0;
        for (int dirNum=0;dirNum<4;dirNum++){
            int nx = x+dx[dirNum];
            int ny = y+dy[dirNum];
            if (!inRange(nx,ny)||graph[nx][ny]==0) continue;
            graph[nx][ny] = 0;
            pCnt++;
            DFS(nx, ny);
        }
    }

    private static boolean inRange(int x, int y){
        return x>=0&&x<N&&y>=0&&y<N;
    }
}