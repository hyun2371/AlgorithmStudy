import java.util.*;
class Solution {
    static int[][] dArr = {{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
    static boolean[][] ch;
    static int len;
    public int solution(int[][] board) {
        int cnt = 0;
        len = board.length;
        ch = new boolean[len][len];
        
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                if (board[i][j]==1) spread(i,j);
            }
        }
        
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                if (ch[i][j]) cnt++;
            }
        }
        
        return len*len-cnt;
    }
    private static void spread(int r, int c){
        ch[r][c] = true;
        for (int[] d:dArr){
            int dr = r+d[0];
            int dc = c+d[1];
            if (dr<0||dc<0||dr>=len||dc>=len) continue;
            ch[dr][dc] = true;
        }
    }
}