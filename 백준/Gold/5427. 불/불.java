import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0,0,-1,1};
	static int[][] f_dis, p_dis;
	static int W, H;
	static int fx,fy,px, py;
	static Queue<Pos> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			f_dis = new int[H][W];
			p_dis = new int[H][W];
			for (int i = 0; i < H; i++) {
				Arrays.fill(f_dis[i],-1);
				Arrays.fill(p_dis[i],-1);
			}

			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					char x = s.charAt(j);
					if (x=='#') {
						f_dis[i][j] = 0;
						p_dis[i][j] = 0;
					}
					else if (x=='*'){
						fx = i; fy = j;
						f_dis[i][j] = 0;
						q.offer(new Pos(i, j));
						p_dis[i][j] = 0;
					}
					else if (x=='@'){
						px = i; py = j;
						p_dis[i][j] = 0;
					}
				}
			}
			F_BFS(fx, fy);
			int answer = P_BFS(px, py);
			sb.append(answer == -1 ? "IMPOSSIBLE" : answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void F_BFS(int x, int y){
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur.x+dx[d];
				int ny = cur.y+dy[d];
				if (nx<0||ny<0||nx>=H||ny>=W) continue;
				if (f_dis[nx][ny]>=0) continue;
				f_dis[nx][ny] = f_dis[cur.x][cur.y]+1;
				q.offer(new Pos(nx, ny));
			}
		}
	}

	private static int P_BFS(int x, int y){
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x, y));
		p_dis[x][y] = 0;
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur.x+dx[d];
				int ny = cur.y+dy[d];
				if (nx<0||ny<0||nx>=H||ny>=W) {
					return p_dis[cur.x][cur.y]+1;
				}
				if (p_dis[nx][ny]>=0) continue;

				if (f_dis[nx][ny]!=-1&&p_dis[cur.x][cur.y]+1>=f_dis[nx][ny]) continue;
				p_dis[nx][ny] = p_dis[cur.x][cur.y]+1;
				q.offer(new Pos(nx, ny));
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