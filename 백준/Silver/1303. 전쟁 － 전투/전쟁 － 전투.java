import java.io.*;
import java.util.*;

public class Main {
	static char[][] graph;
	static boolean[][] visited;
	static int cnt = 0, totalW = 0, totalB = 0;
	static int n, m;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void DFS(int x, int y, char t) {
		visited[x][y] = true; // 현재 위치 방문
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < m && ny >= 0 && ny < n && graph[nx][ny] == t && !visited[nx][ny]) {
				DFS(nx, ny, t); // 연속된 영역 탐색
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //열
		m = Integer.parseInt(st.nextToken()); //행
		graph = new char[m][n];
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					if (graph[i][j] == 'W') {
						cnt = 0; // 개수 초기화
						DFS(i, j, 'W');
						totalW += cnt * cnt; //연속된 영역 개수^2
					} else { //'B'
						cnt = 0;
						DFS(i, j, 'B');
						totalB += cnt * cnt;
					}
				}
			}
		}

		System.out.println(totalW + " " + totalB);
	}
}