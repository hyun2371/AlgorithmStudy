import java.util.*;
class Solution {
    int[] dx = {0,0};
    int[] dy = {1,-1};
    public int solution(int n, int w, int num) {
        int h = (n/w)+1;
        int[][] arr = new int[h][w];
        
        int cx = h-1, cy = 0;
        int value = 1;
        int dirNum = 0;
        int c=0;
        while (value<=n){
            arr[cx][cy] = value++;
            if (arr[cx][cy]==num) c = cy;
            int nx = cx+dx[dirNum];
            int ny = cy+dy[dirNum];
            if (!inRange(nx,ny,h,w)){
                nx = cx-1;
                ny = cy;
                dirNum = (dirNum+1)%2;
            } 
            cx = nx;
            cy = ny;
        }
        int r = 0, cnt = 1;
        while (true){
            if (arr[r][c]==num) break;
            if (arr[r][c]!=0) cnt++;
            r++;
        }

        return cnt;
    }
    
    static boolean inRange(int x, int y,int h,int w){
        return x>=0&&y>=0&&x<h&&y<w;
    }
}