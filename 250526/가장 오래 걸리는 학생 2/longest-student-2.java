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

        for (int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x =  Integer.parseInt(st.nextToken());
            int y =  Integer.parseInt(st.nextToken());
            int c =  Integer.parseInt(st.nextToken());
            graph.get(y).add(new Edge(x,c));
        }

        dis = new int[N+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[N] = 0;
        pq.offer(new Edge(N,0));

        dijkstra();

        int answer = Integer.MIN_VALUE;
        for (int i=1;i<N;i++){
            answer = Math.max(answer,dis[i]);
        }
        System.out.println(answer);
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