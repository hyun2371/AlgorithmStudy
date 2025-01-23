import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = {-1, 1, 0, 0}; // 행
	static int[] dy = {0, 0, -1, 1}; // 열
	static int[][] graph;
	static boolean[][] visited; // 방문여부
	static int n, m;
	static int maxS; // 최대 넓이

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열

		graph = new int[n][m];
		visited = new boolean[n][m];
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i=0;i<n;i++){
			for (int j = 0;j<m;j++){
				if (!visited[i][j]&&graph[i][j]==1){
					BFS(i,j);
					cnt++;
				}
			}
		}
		bw.write(cnt+"\n"+maxS);
		bw.flush();
		bw.close();
	}

	private static void BFS(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		visited[x][y] = true;
		int s = 0;
		while (!q.isEmpty()) {
			s++;
			Pos cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (visited[nx][ny] || graph[nx][ny] != 1) continue;

				q.offer(new Pos(nx, ny));
				visited[nx][ny] = true;
			}
			maxS = Math.max(maxS, s);
		}
	}
}

class Pos {
	int x; //행
	int y; //열

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}