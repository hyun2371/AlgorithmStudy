import java.util.*;
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N,M;
    static char[][] arr;
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        arr = new char[N][M];
        int x=0, y=0;
        for (int i=0;i<N;i++){
            arr[i] = board[i].toCharArray();
        }
        
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (arr[i][j]=='R') {
                    x = i; y = j;
                }
            }
        }
        

        return BFS(x,y);
    }
    
    private static int BFS(int x, int y){
        int[][] dis = new int[N][M];
        dis[x][y] = 1;
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x,y));
        
        while (!q.isEmpty()){
            Pos cur = q.poll();
            for (int i=0;i<dx.length;i++){
                int nx = cur.x;
                int ny = cur.y;
                while (inRange(nx,ny)&&arr[nx][ny]!='D'){
                    nx+=dx[i];
                    ny+=dy[i];
                }
                
                nx-=dx[i];
                ny-=dy[i];
                
                if (arr[nx][ny]=='G'){
                    return dis[cur.x][cur.y];
                }
                if (dis[nx][ny]==0){
                    dis[nx][ny] = dis[cur.x][cur.y]+1;
                    q.add(new Pos(nx,ny));
                }
                
            }
            
        }
        return -1;
    }
    
    private static boolean inRange(int x, int y){
        return x>=0&&y>=0&&x<N&&y<M;
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