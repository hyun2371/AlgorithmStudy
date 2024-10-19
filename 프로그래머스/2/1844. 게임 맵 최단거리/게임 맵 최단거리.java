import java.util.*;
class Solution {
    
    static int[][] dis;
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n,m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length; 
        m = maps[0].length;
        dis = new int[n][m];
        
        
        BFS(maps);
        if (dis[n-1][m-1]==0) return -1;
        else return dis[n-1][m-1];
    }
    
    public static void BFS(int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        dis[0][0] = 1;
        q.offer(new int[]{0,0});
        
        while (!q.isEmpty()){
            int[] cur = q.poll();
            for (int[] arr : move){
                int nx = cur[0]+arr[0];
                int ny = cur[1]+arr[1];

                if ((nx>=0 && nx<m && ny>=0 && ny<n) &&
                    maps[ny][nx]==1 && dis[ny][nx]==0){
                    dis[ny][nx] = dis[cur[1]][cur[0]] + 1;
                    if (dis[n-1][m-1]>0) return;
                    q.offer(new int[]{nx,ny});
                }
            }   
        }
    }
}