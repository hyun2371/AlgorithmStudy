import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] arr;
    static int N,M, curX, curY; //arr 행, 열; 현재 x,y
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        //arr, 시작점 초기화
        initArr(park,routes);
        
        for (int i=0;i<routes.length;i++){
            int dirNum = getDirNum(routes[i].charAt(0));
            int dis = (int)(routes[i].charAt(2)-'0');
            move(dirNum,dis);
        }
        
        answer[0] = curX;
        answer[1] = curY;
        return answer;
    }
    
    private static void move(int dirNum, int dis){
        if (canGo(dirNum,dis)){
            curX += dx[dirNum]*dis;
            curY += dy[dirNum]*dis;
        }
    }
    
    private static boolean canGo(int dirNum, int dis){
        int nx = curX, ny = curY;
        for (int i = 0; i < dis; i++) {
            nx += dx[dirNum];
            ny += dy[dirNum];
            if (!inRange(nx, ny) || arr[nx][ny] == 0) return false;
        }
        return true;
    }
    
    private static boolean inRange(int x, int y){
        return x>=0&&y>=0&&x<N&&y<M;
    }
    
    private static int getDirNum(char c){
        if (c=='N') return 0;
        if (c=='S') return 1;
        if (c=='W') return 2;
        else return 3;
    }
    
    private static void initArr(String[] park, String[] routes){
        N = park.length;
        M = park[0].length();
        arr = new int[N][M];
        for (int i=0;i<N;i++){
            String s = park[i];
            for (int j=0;j<M;j++){
                if (s.charAt(j)=='S'){
                    arr[i][j] = 1;
                    curX = i; curY = j;
                }
                else if (s.charAt(j)=='O'){
                    arr[i][j] = 1;
                }
                else arr[i][j] = 0;
            }
        }
    }
}