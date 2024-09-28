import java.util.*;

public class Main {
	static int[][] graph, dis;
	static int n, m;
	// 상하좌우
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void BFS() {
		Queue<Pointer> queue = new LinkedList<>();
		queue.offer(new Pointer(1, 1)); //출발위치
		dis[1][1] = 1;
		graph[1][1] = 0;
		while (!queue.isEmpty()) {
			Pointer cp = queue.poll(); //현재위치
			for (int i = 0; i < 4; i++) {
				int nx = cp.x + dx[i];
				int ny = cp.y + dy[i];
				if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && graph[nx][ny] == 1) {
					graph[nx][ny] = 0;
					dis[nx][ny] = dis[cp.x][cp.y] + 1;
					queue.offer(new Pointer(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		graph = new int[n + 1][m + 1]; //이동가능여부
		dis = new int[n + 1][m + 1]; //거리

		for (int i = 1; i <= n; i++) {
			String s = sc.next();
			for (int j = 1; j <= m; j++) {
				graph[i][j] = s.charAt(j - 1) - '0';
			}
		}

		BFS();
		System.out.println(dis[n][m]);
	}
}

class Pointer {
	int x, y;

	public Pointer(int x, int y) {
		this.x = x;
		this.y = y;
	}
}