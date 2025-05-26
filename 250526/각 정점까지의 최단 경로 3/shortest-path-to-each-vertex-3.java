import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static List<List<Edge>> graph = new ArrayList<>();
    static Queue<Edge> pq = new PriorityQueue<>();
    static int[] dis;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N =  Integer.parseInt(st.nextToken());
        M =  Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Edge(y,c));
        }


        dis = new int[N+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[1] = 0;
        pq.offer(new Edge(1,0));

        while (!pq.isEmpty()){
            Edge cur = pq.poll(); // 현재 최소 비용 간선
            int curVertex = cur.vertex; //간선의 정점
            int curCost = cur.cost; // 간선의 비용 (시작점~curVertex)
            if (dis[curVertex]<curCost) continue; //저장된 정점에 대한 거리< 현재 간선의 비용-> 갱신할 필요없음
            for(Edge e : graph.get(curVertex)){ //현재 정점과 연결된 정점들
                //시작점~연결된 정점| 시작점~ 현재 정점 + 현재 정점~연결된 정점
                if (dis[e.vertex]>curCost+e.cost){
                    dis[e.vertex] = curCost+e.cost;
                    pq.offer(new Edge(e.vertex,dis[e.vertex]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=2;i<=N;i++){
            if (dis[i]==Integer.MAX_VALUE)
                sb.append(-1);
            else
                sb.append(dis[i]);
            sb.append("\n");
        }
        System.out.println(sb);

    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int cost;

    public Edge(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }

    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}