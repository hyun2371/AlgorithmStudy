import java.io.*;
import java.util.*;

public class Main {
	static int[][][] graph, dis;
	static Queue<Pos> queue = new LinkedList<>(); //main에서도 쓰임
	// 이동 가능한 좌표
	static int[] dx = {0, 0, -1, 1, 0, 0};
	static int[] dy = {-1, 1, 0, 0, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	static int h, n, m;

	static void BFS() {
		while (!queue.isEmpty()) {
			Pos cp = queue.poll();
			for (int i = 0; i < 6; i++) {
				int nx = cp.x + dx[i];
				int ny = cp.y + dy[i];
				int nz = cp.z + dz[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h && graph[nz][nx][ny] == 0) {
					graph[nz][nx][ny] = 1;
					queue.offer(new Pos(nx, ny, nz));
					dis[nz][nx][ny] = dis[cp.z][cp.x][cp.y] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 열
		n = Integer.parseInt(st.nextToken()); // 행
		h = Integer.parseInt(st.nextToken()); // 높이

		graph = new int[h][n][m];
		dis = new int[h][n][m];

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					graph[k][i][j] = Integer.parseInt(st.nextToken());
					if (graph[k][i][j] == 1) {
						queue.offer(new Pos(i, j, k));
					}
				}
			}
		}
		BFS();
		boolean flag = true; // 사과 익었는지 여부

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (graph[k][i][j] == 0) {
						flag = false;
						break;
					}
				}
			}
		}
		int ans = 0;
		if (flag) {
			for (int k = 0; k < h; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						ans = Math.max(ans, dis[k][i][j]);
					}
				}
			}
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
	}

}

class Pos {
	int x, y, z;

	public Pos(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}