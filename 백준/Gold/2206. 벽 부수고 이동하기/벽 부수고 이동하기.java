import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] graph;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N][M];
		isVisited = new boolean[N][M][2]; //충돌 여부 추가 구분 (0->충돌, 1->충돌x)

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = line.charAt(j)-'0';
			}
		}
		System.out.println(BFS());
	}

	private static int BFS() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0, 0, 1, false));
		isVisited[0][0][0] = true;

		while (!q.isEmpty()){
			Pos cur = q.poll();
			if (cur.x==N-1&&cur.y==M-1) return cur.dis;
			for (int d = 0; d <4 ; d++) {
				int nx = cur.x+dx[d];
				int ny = cur.y+dy[d];
				if (!inRange(nx,ny)) continue;

				if (graph[nx][ny]==1){ //벽
					if (!cur.isCrashed&&!isVisited[nx][ny][1]){//이전에 충돌 없고, 방문(충돌o) 안함
						isVisited[nx][ny][1] = true;
						q.offer(new Pos(nx,ny,cur.dis+1,true));
					}
				}
				else { //벽 아님
					int isCrashed = cur.isCrashed?1:0;
					if (!isVisited[nx][ny][isCrashed]){ //방문(충돌x) 안함
						isVisited[nx][ny][isCrashed] = true;
						q.offer(new Pos(nx,ny,cur.dis+1, cur.isCrashed));
					}
				}
			}
		}
		return -1;
	}
	private static boolean inRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
}

class Pos {
	int x, y, dis;
	boolean isCrashed; // 여태까지 벽 부쉈는지

	public Pos(int x, int y, int dis, boolean isCrashed) {
		this.x = x;
		this.y = y;
		this.dis = dis;
		this.isCrashed = isCrashed;
	}
}
