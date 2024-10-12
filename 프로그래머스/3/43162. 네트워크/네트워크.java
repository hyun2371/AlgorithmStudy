import java.util.*;

class Solution {
    static boolean[] visited; // 방문여부
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i=0;i<n;i++){
            if (!visited[i]){
                BFS(i,computers); // 한 네트워크
                answer++;
            }
            
        }
        return answer;
    }
    
    public static void BFS(int v, int[][] computers){
        Queue<Integer> que = new LinkedList<>();
        que.offer(v);
        visited[v] = true;
        while (!que.isEmpty()){
            int cur = que.poll();
            for (int i = 0;i<computers[0].length;i++){
                if (!visited[i]&&i!=cur&&computers[cur][i]==1){
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}