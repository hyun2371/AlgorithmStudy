import java.util.*;
import java.io.*;
public class Main {
	static int[] dis;
	static List<List<Edge>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(x).add(new Edge(y,c));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		dijkstra(s);
		System.out.print(dis[t]);
	}

	private static void dijkstra(int s){
		Queue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(s,0));
		dis[s] = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll(); //현재 정점
			if (cur.cost>dis[cur.vertex])continue;
			for (Edge e : graph.get(cur.vertex)) {//꺼내는 정점
				if (dis[e.vertex]>cur.cost+e.cost){
					dis[e.vertex] = cur.cost+e.cost;
					pq.offer(new Edge(e.vertex, dis[e.vertex]));
				}
			}
		}
	}
}

class Edge implements Comparable<Edge>{
	int vertex;
	int cost;

	public Edge(int vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o){
		return this.cost-o.cost;
	}
}