import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] answer;
	static int count=1;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정점수
		int M = Integer.parseInt(st.nextToken()); //간선수
		int R = Integer.parseInt(st.nextToken()); //시작정점

		for (int i=0;i<=N;i++){ // 정점수+1만큼 초기화
			graph.add(new ArrayList<>());
		}

		for (int i=0;i<M;i++){ //각 정점 대입
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (ArrayList<Integer> list : graph) {
			Collections.sort(list);
		}


		answer = new int[N+1];
		visited = new boolean[N+1];

		DFS(R);

		for (int i=1;i<=N;i++){
			System.out.println(answer[i]);
		}
	}

	static void DFS(int x){
		answer[x] = count++;
		visited[x] = true;

		for (int nx : graph.get(x)){
			if (!visited[nx]) {
				DFS(nx);
			}
		}
	}
}