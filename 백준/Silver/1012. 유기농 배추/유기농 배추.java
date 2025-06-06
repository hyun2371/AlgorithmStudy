import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static int[][] graph;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- >0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //열
			N = Integer.parseInt(st.nextToken()); //행
			K = Integer.parseInt(st.nextToken());
			graph = new int[N][M];
			while (K-- >0){
				st = new StringTokenizer(br.readLine());
				int Y = Integer.parseInt(st.nextToken());
				int X = Integer.parseInt(st.nextToken());
				graph[X][Y] = 1;
			}

			int cnt=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (graph[i][j] == 1){
						DFS(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void DFS(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!inRange(nx, ny)||graph[nx][ny]==0) continue;
			graph[nx][ny]=0;
			DFS(nx, ny);
		}
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}