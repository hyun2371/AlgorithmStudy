import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] dis;
	static List<List<Edge>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dis = new int[N + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(x).add(new Edge(y, c));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		solution(start);
		int target = Integer.parseInt(st.nextToken());
		System.out.println(dis[target]);
	}

	private static void solution(int v) {
		Queue<Edge> pq = new PriorityQueue<>();
		dis[v] = 0;
		pq.offer(new Edge(v, 0));


		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int curVertex = cur.vertex;
			int curCost = cur.cost;
			if (curCost > dis[curVertex]) continue;

			for (Edge e : graph.get(curVertex)) {
				if (dis[curVertex]+e.cost<dis[e.vertex]){
					dis[e.vertex] = dis[curVertex]+e.cost;
					pq.offer(new Edge(e.vertex,dis[e.vertex]));
				}
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int vertex;
	int cost;

	public Edge(int vertex, int cost) {
		this.vertex = vertex;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge e) {
		return this.cost - e.cost;
	}
}