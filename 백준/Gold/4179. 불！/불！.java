import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static int[][] dis_f, dis_p;
	static Queue<Pos> q_f = new LinkedList<>(), q_p = new LinkedList<>();
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		dis_f = new int[R][C];
		dis_p = new int[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = s.charAt(j);
				if (c == '.') { // 통로
					dis_f[i][j] = -1;
					dis_p[i][j] = -1;
				}
				if (c == 'F') {
					dis_f[i][j] = 0;
					q_f.add(new Pos(i, j));
				}
				if (c == 'J') {
					dis_f[i][j] = -1; //플레이어 있던 곳도 통로
					dis_p[i][j] = 0;
					q_p.add(new Pos(i, j));
				}
			}
		}
		BFS_F();
		int time = BFS_P();
		System.out.println(time==-1?"IMPOSSIBLE":time);
	}

	// 불 거리 구함
	private static void BFS_F() {
		while (!q_f.isEmpty()) {
			Pos cur = q_f.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if (dis_f[nx][ny] != -1) continue;

				dis_f[nx][ny] = dis_f[cur.x][cur.y] + 1;
				q_f.offer(new Pos(nx, ny));
			}
		}
	}

	private static int BFS_P() {
		while (!q_p.isEmpty()) {
			Pos cur = q_p.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C) { // 범위 벗어남 -> 탈출 성공
					return dis_p[cur.x][cur.y] + 1;
				}
				if (dis_p[nx][ny] != -1) continue;
				if (dis_f[nx][ny]!=-1&&dis_p[cur.x][cur.y] + 1 >= dis_f[nx][ny]) continue;

				dis_p[nx][ny] = dis_p[cur.x][cur.y] + 1;
				q_p.offer(new Pos(nx, ny));
			}
		}
		return -1;
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
