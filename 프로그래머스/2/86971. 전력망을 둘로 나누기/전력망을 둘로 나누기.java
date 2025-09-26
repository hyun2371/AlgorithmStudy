import java.util.*;
class Solution {
    static int cnt;
    static List<List<Integer>> graph = new ArrayList<>();
    public int solution(int n, int[][] wires) {
        int answer = n;
        initGraph(n,wires);
        
        for (int i=0;i<wires.length;i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            boolean[] visited = new boolean[n+1];
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));
            cnt = 0;
            DFS(1,visited);
            
            int diff = Math.abs(cnt-(n-cnt));
            answer = Math.min(answer,diff);
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        return answer;
    }
    
    private static void DFS(int cur, boolean[] visited){
        visited[cur] = true;
        cnt++;
        for (int next : graph.get(cur)){
            if (!visited[next]){
                DFS(next,visited);
            }
        }
    }
    
    private static void initGraph(int n, int[][] wires){
        for (int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        for (int i=0;i<wires.length;i++){
            int s = wires[i][0];
            int e = wires[i][1];
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
    }
}