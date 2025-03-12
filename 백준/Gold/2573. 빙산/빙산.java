import java.io.*;
import java.util.*;

public class Main {
	static int[][] graph, vis;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M; //행, 열

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

		int day = 0;
		while (true) {
			vis = new int[N][M]; // 날마다 방문여부 초기화
			int cnt = 0;
            boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (graph[i][j]>0&&vis[i][j]==0) {
						BFS(i, j);
						cnt++;
					}
                    if (graph[i][j]>0) flag = true;
				}
                
			}
            if (!flag) {
					System.out.println(0);return;
				}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (vis[i][j]>0)
						graph[i][j] -= (vis[i][j] - 1);

				}
			}
			if (cnt>=2) break;
			day++;
		}
		System.out.println(day);
	}

	private static void BFS(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x, y));
		vis[x][y] = 1;


		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (graph[nx][ny] <= 0) { //바다 여부 체크
					vis[cur.x][cur.y]++;
					continue;
				}

				if (vis[nx][ny] > 0) continue; // 방문여부 체크

				//방문하기
				q.offer(new Pos(nx, ny));
				vis[nx][ny] = 1;
			}
		}
	}
}

class Pos {
    int x,y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}