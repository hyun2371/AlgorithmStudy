import java.util.*;
class Solution {
    static int[] cost, limit;
    static boolean[] visited;
    static int len, result;
    
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        cost = new int[len];
        limit = new int[len];
        visited = new boolean[len];
        for (int i=0;i<dungeons.length;i++){
            limit[i] = dungeons[i][0];
            cost[i] = dungeons[i][1];
        }

        DFS(0,k);
        return result;
    }
    
    private static void DFS(int cnt, int remain){
        result = Math.max(result, cnt);
        
        for (int i=0;i<len;i++){
            if (visited[i]) continue;
            if (remain<limit[i]) { //최소 피로도 만족x
                continue;
            }
            visited[i] = true;
            DFS(cnt+1,remain-cost[i]);
            visited[i] = false;
        }
    }
}