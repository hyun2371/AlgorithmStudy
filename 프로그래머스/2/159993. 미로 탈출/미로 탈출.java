import java.util.*;
class Solution {
    static int N,M;
    static int lx,ly, ex,ey, sx,sy;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] dis;
    static char[][] arr;
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        initMaps(maps);
        int answer = 0;

        int dis1 = BFS(sx,sy,lx,ly);
        if (dis1==-1) return -1;
        
        int dis2 = BFS(lx,ly,ex,ey);
        if (dis2==-1) return -1;
        
        return dis1+dis2;
    }
    
    private static void initDis(){
        dis = new int[N][M];
        for (int i=0;i<N;i++){
            Arrays.fill(dis[i],-1);
        }
    }
    
    private static void initMaps(String[] maps){
        arr = new char[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                arr[i][j] = maps[i].charAt(j);
                if (arr[i][j]=='L'){
                    lx = i; ly=j;
                }
                else if (arr[i][j]=='E'){
                    ex = i; ey = j;
                }
                else if (arr[i][j]=='S'){
                    sx = i; sy=j;
                }
            }
        }
    }
    
    private static int BFS(int x1, int y1, int x2, int y2){
        initDis();  
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x1,y1));
        dis[x1][y1] = 0;
        while (!q.isEmpty()){
            Pos cur = q.poll();
            for (int d=0;d<4;d++){
                int nx = cur.x+dx[d];
                int ny = cur.y+dy[d];
                if (!inRange(nx,ny)||arr[nx][ny]=='X'||dis[nx][ny]>=0) continue;
                dis[nx][ny] = dis[cur.x][cur.y]+1;
                q.offer(new Pos(nx,ny));
                if (nx==x2&&ny==y2) return dis[x2][y2];
            }
        }
        return -1;
    }
    
    private static boolean inRange(int x, int y){
        return x>=0&&x<N&&y>=0&&y<M;
    }
}

class Pos{
    int x;
    int y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}