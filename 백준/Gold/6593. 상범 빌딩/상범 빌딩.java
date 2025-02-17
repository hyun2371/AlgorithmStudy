import java.util.*;
import java.io.*;

public class Main {
	static int L,R,C;
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	static char[][][] graph;
	static int[][][] dis;
	static int sx, sy, sz, ex, ey, ez;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		while (true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L==0&&R==0&&C==0){
				System.out.println(sb);
				return;
			}
			graph = new char[L][R][C];
			dis = new int[L][R][C];

			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					String s = br.readLine();
					for (int c = 0; c < C; c++) {
						char alpha = s.charAt(c);
						graph[l][r][c] = alpha;
						if (alpha == 'S') {
							sx = r;
							sy = c;
							sz = l;
						} else if (alpha == 'E') {
							ex = r;
							ey = c;
							ez = l;
						}
					}
				}
				br.readLine();
			}
			BFS();
		}
	}

	private static void BFS() {
		Queue<P> q = new LinkedList<>();
		dis[sz][sx][sy] = 1;
		q.offer(new P(sx, sy, sz));

		while (!q.isEmpty()) {
			P cur = q.poll();
			for (int i = 0; i < 6; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int nz = cur.z + dz[i];
				if (nx < 0 || ny < 0 || nz < 0 || nx >= R || ny >= C || nz >= L) continue;
				if (dis[nz][nx][ny] != 0||graph[nz][nx][ny]=='#') continue;
				dis[nz][nx][ny] = dis[cur.z][cur.x][cur.y] + 1;
				if (nx == ex && ny == ey && nz == ez) {
					sb.append("Escaped in ").append(dis[nz][nx][ny]-1).append(" minute(s).\n");
					return;
				}
				q.offer(new P(nx, ny, nz));
			}
		}
		sb.append("Trapped!\n");
	}
}

class P {
	int x, y, z;

	public P(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}