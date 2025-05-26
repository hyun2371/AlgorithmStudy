import java.util.*;
import java.io.*;

public class Main {
    static List<List<Edge>> graph = new ArrayList<>();
    static Queue<Edge> pq = new PriorityQueue();
    static int[] dis;
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N =  Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        for (int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x =  Integer.parseInt(st.nextToken());
            int y =  Integer.parseInt(st.nextToken());
            int c =  Integer.parseInt(st.nextToken());
            graph.get(x).add(new Edge(y,c));
            graph.get(y).add(new Edge(x,c));
        }

        dis = new int[N+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[K] = 0;
        pq.offer(new Edge(K,0));

        dijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=N;i++){
            if (dis[i]==Integer.MAX_VALUE) sb.append(-1);
            else sb.append(dis[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(){
        while (!pq.isEmpty()){
            Edge cur = pq.poll();
            int curVertex = cur.vertex;
            int curCost = cur.cost;
            if (curCost>dis[curVertex]) continue;

            for (Edge e:graph.get(curVertex)){
                if (dis[e.vertex]>curCost+e.cost){
                    dis[e.vertex] = curCost+e.cost;
                    pq.offer(new Edge(e.vertex,dis[e.vertex]));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int vertex;
    int cost;

    public Edge(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }
    public int compareTo(Edge e){
        return this.cost-e.cost;
    }
}