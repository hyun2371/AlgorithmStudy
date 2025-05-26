import java.util.*;
import java.io.*;
public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] arr;
	static int N, M, cx, cy, d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		st = new StringTokenizer(br.readLine());
		cx = Integer.parseInt(st.nextToken());
		cy = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(clean());
	}

	private static int clean() {
		int cnt = 1;
		arr[cx][cy] = -1; //청소
		while (inRange(cx, cy)&&arr[cx][cy]!=1) {
			boolean isClean = false;
			for (int i = 0; i < 4; i++) {//반시계 방향 탐색
				d = (d + 3) % 4; //반시계 90도 회전
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if (!inRange(nx, ny) || arr[nx][ny] != 0)
					continue; //범위 벗어나거나, 청소할 수 없으면
				cx = nx;
				cy = ny; //전진
				arr[cx][cy] = -1; //청소
				cnt++; isClean = true;
				break;
			}
			if (!isClean){
				cx -= dx[d]; //후진
				cy -= dy[d];
			}
		}

		return cnt;
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}