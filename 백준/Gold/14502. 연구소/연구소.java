import java.util.*;
import java.io.*;

public class Main {
	static int N, M, max_cnt;
	static int[][] graph;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0);

		System.out.println(max_cnt);
	}

	private static void DFS(int lv) {
		if (lv == 3) {
			BFS(graph);
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] != 0) continue;
				graph[i][j] = 1;
				DFS(lv + 1);
				graph[i][j] = 0;
			}
		}

	}

	private static void BFS(int[][] tmp) {
		// 배열 복사
		int[][] graph = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				graph[i][j] = tmp[i][j];
			}
		}

		Queue<P> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 2) q.offer(new P(i, j));
			}
		}

		while (!q.isEmpty()) {
			P cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (graph[nx][ny] != 0)
					continue;
				q.offer(new P(nx, ny));
				graph[nx][ny] = 2;
			}
		}
		max_cnt = Math.max(max_cnt, count(graph));
	}

	private static int count(int[][] graph) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j]==0) count++;
			}
		}
		return count;
	}
}

class P {
	int x, y;

	public P(int x, int y) {
		this.x = x;
		this.y = y;
	}
}