import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, L, R;
	static int total;
	static int[][] A;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		init();
		int days = 0;

		while (true) {
			boolean isMoved = false;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						List<Pos> union = new ArrayList<>();
						total = 0;
						DFS(i, j, union);
						if (union.size() > 1) {
							isMoved = true;
							int avg = total / union.size();
							for (Pos pos : union) {
								A[pos.x][pos.y] = avg;
							}
						}

					}
				}
			}
			if (!isMoved) break;
			days++;
		}

		System.out.println(days);
	}

	private static void DFS(int x, int y, List<Pos> union) {
		union.add(new Pos(x, y));
		visited[x][y] = true;
		total += A[x][y];
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!inRange(nx, ny) || visited[nx][ny])
				continue;
			int sub = Math.abs(A[x][y] - A[nx][ny]);
			if (sub < L || sub > R)
				continue;

			//연합 충족
			DFS(nx, ny, union);
		}
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}