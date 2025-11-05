import java.util.*;
import java.io.*;

public class Main {
	static final int LEN = 19;
	static int[] dx = {-1, -1, 0, -1};
	static int[] dy = {-1, 0, -1, 1};
	static int[][] arr = new int[LEN][LEN];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < LEN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < LEN; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < LEN; j++) {
			for (int i = 0; i < LEN; i++) {
				if (arr[i][j] > 0) {
					if (isFive(i, j, arr[i][j])) {
						sb.append(arr[i][j]).append("\n").append(i + 1).append(" ").append(j + 1);
						System.out.print(sb);
						return;
					}
				}
			}
		}
		System.out.print(0);
	}

	private static boolean isFive(int x, int y, int color) {
		for (int dir = 0; dir < dx.length; dir++) {
			int cnt = getCnt(x, y, dx[dir], dy[dir], color) + getCnt(x, y, -dx[dir], -dy[dir], color)+ 1;
			if (cnt == 5) return true;
		}

		return false;
	}

	private static int getCnt(int x, int y, int dx, int dy, int color) {
		int cnt = 0;
		int cx = x, cy = y;
		while (true) {
			int nx = cx+dx;
			int ny = cy+dy;
			if (!inRange(nx,ny)||arr[nx][ny]!=color) break;
			cx = nx; cy = ny;
			cnt++;
		}

		return cnt;
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && y >= 0 && x < LEN && y < LEN;
	}
}