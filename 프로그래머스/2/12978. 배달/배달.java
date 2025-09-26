import java.util.*;

class Solution {
    static List<Edge>[] graph;
    static int[] dis;
    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N+1];
        dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        for (int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        for (int i=0;i<road.length;i++){
            int x = road[i][0];
            int y = road[i][1];
            int z = road[i][2];
            graph[x].add(new Edge(y,z));
            graph[y].add(new Edge(x,z));
        }
        solution();
        int cnt = 0;

        for (int i=1;i<=N;i++){
            if (dis[i]<=K) cnt++;
        }
        
        return cnt;
    }
    
    private static void solution(){
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1,0));
        dis[1] = 0;
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if (cur.c>dis[cur.v]) continue;
            for (Edge next : graph[cur.v]){
                if (dis[next.v]>dis[cur.v]+next.c){
                    dis[next.v] = dis[cur.v]+next.c;
                    pq.offer(new Edge(next.v,dis[next.v]));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int v;
    int c;
    public Edge(int v, int c){
        this.v = v;
        this.c = c;
    }
    public int compareTo(Edge o){
        return this.c-o.c;
    }
}

