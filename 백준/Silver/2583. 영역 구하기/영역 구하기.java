import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] dis;
	static int M, N;
	static int area;
	static List<Integer> areas = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 행
		N = Integer.parseInt(st.nextToken()); // 열
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;

		dis = new int[M][N]; //거리

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			fillArr(x1, y1, x2, y2);
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (dis[i][j] == 0) {
					BFS(i, j);
					cnt++;
					areas.add(area);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		Collections.sort(areas);
		for (int a : areas) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}

	private static void fillArr(int x1, int y1, int x2, int y2) {
		for (int i = M - y2; i < M - y1; i++) {
			for (int j = x1; j < x2; j++) {
				dis[i][j] = -1;
			}
		}
	}

	private static void BFS(int x, int y) {
		dis[x][y] = 1;
		area = 1;
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x, y));

		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;
				if (dis[nx][ny] != 0)
					continue; //-1 방문 불가, 1이상 방문함
				dis[nx][ny] = dis[cur.x][cur.y] + 1;
				q.offer(new Pos(nx, ny));
				area++;
			}
		}
	}
}

class Pos {
	int x;
	int y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}