import java.util.*;
import java.io.*;

public class Main {
   static List<List<Edge>> graph = new ArrayList<>();
   static int[] dis;
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        
        for (int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Edge(y,c));
            graph.get(y).add(new Edge(x,c));
        }

        dis = new int[N+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        Dijkstra(K);

        for (int i=1;i<=N;i++){
            if (dis[i]==Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(dis[i]);
        }
    }


    private static void Dijkstra(int s){
        Queue<Edge> pq = new PriorityQueue<>();
        dis[s] = 0;
        pq.offer(new Edge(s,0));

        while (!pq.isEmpty()){
           Edge cur = pq.poll();
           if (cur.c>dis[cur.v]) continue;
           for (Edge e : graph.get(cur.v)){
                if (dis[e.v]>e.c+cur.c){
                    dis[e.v] = e.c+cur.c;
                    pq.offer(new Edge(e.v,dis[e.v]));
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

    public int compareTo(Edge e){
        return this.c-e.c;
    }
}