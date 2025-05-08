import java.util.Scanner;
public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];
        int tmp = 0; // 탐색시 최대 높이
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                graph[i][j] = sc.nextInt();
                tmp = Math.max(graph[i][j],tmp);
            }
        }

        //안전영역 최대 개수와 그 때 높이 
        int maxCnt = Integer.MIN_VALUE, answerH=0;
        for (int h=1;h<=tmp;h++){
            int cnt = 0; // 높이별 안전영역 개수
            visited = new boolean[N][M]; //방문여부 초기화
            for (int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    if (!visited[i][j]&&graph[i][j]>h) {//방문 안전영역 방문
                        visited[i][j] = true;
                        DFS(i,j,h);
                        cnt++;
                    }
                    if (cnt>maxCnt){
                        maxCnt = cnt;
                        answerH = h;
                    }                    
                }
            }
        } 
        System.out.println(answerH+" "+ maxCnt);  
    }

    private static void DFS(int x,int y, int h){
        for (int d=0;d<4;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if (!inRange(nx,ny)||graph[nx][ny]<=h||visited[nx][ny]) continue;
            visited[nx][ny] = true;
            DFS(nx,ny,h);
        }
    }

    private static boolean inRange(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
    }
}