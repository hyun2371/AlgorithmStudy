import java.util.*;
import java.io.*;

public class Main {
	static int[][] graph, dis;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	static int N, M;
	static Queue<Pos> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 행

		graph = new int[N][M];
		dis = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1)
					q.offer(new Pos(j, i));
			}
		}
		BFS();
		System.out.println(day());
	}

	private static void BFS() {
		while (!q.isEmpty()) {

			Pos cur = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx<0||ny<0||nx>=M||ny>=N) continue;
				if (graph[ny][nx]==0){
					graph[ny][nx]=1;
					dis[ny][nx] = dis[cur.y][cur.x]+1;
					q.offer(new Pos(nx, ny));
				}
			}
		}
	}

	private static int day(){
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0)
					return -1;
				answer = Math.max(dis[i][j],answer);
			}
		}
		return answer;
	}
}

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}