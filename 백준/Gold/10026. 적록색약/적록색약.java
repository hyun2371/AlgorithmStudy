import java.util.*;
import java.io.*;

public class Main {
	static char[][] graph;
	static boolean[][] ch1, ch2;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cnt1, cnt2, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new char[N][N];
		ch1 = new boolean[N][N];
		ch2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				graph[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!ch1[i][j]) {
					DFS1(i, j, graph[i][j]);
					cnt1++;
				}
				if (!ch2[i][j]){
					DFS2(i, j, graph[i][j]);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1+" "+cnt2);
	}

	private static void DFS1(int x, int y, char c) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if (ch1[nx][ny]) continue;
			if (graph[nx][ny] != c) continue;
			ch1[nx][ny] = true;
			DFS1(x + dx[i], y + dy[i], c);
		}
	}

	private static void DFS2(int x, int y, char c) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if (ch2[nx][ny]) continue;

			if ((c=='R'||c=='G')&&graph[nx][ny]=='B') continue;
			else if (c=='B'&&graph[nx][ny]!='B') continue;


			ch2[nx][ny] = true;
			DFS2(x + dx[i], y + dy[i], c);
		}
	}
}