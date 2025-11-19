import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        boolean[][] isPuddle = new boolean[n][m];
        
        //장애물 저장
        for (int[] puddle: puddles){
            int c = puddle[0]-1;
            int r = puddle[1]-1;
            isPuddle[r][c] = true;
        }
        int[][] d = new int[n][m];
        //초기항
        for (int i=0;i<n;i++){
            if (isPuddle[i][0]) break;
            d[i][0] = 1;
        }
        for (int i=0;i<m;i++){
            if (isPuddle[0][i]) break;
            d[0][i] = 1;
        }
        
        //점화식
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                if (isPuddle[i][j]) continue;
                d[i][j] = (d[i-1][j]+d[i][j-1])%1_000_000_007;
            }
        }
        
        return d[n-1][m-1];
    }
}