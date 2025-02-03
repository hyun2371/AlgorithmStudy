import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3]; // i번째 집 j번째 색깔
		int[][] d = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		d[0][0] = cost[0][0];
		d[0][1] = cost[0][1];
		d[0][2] = cost[0][2];

		for (int i = 1; i < N; i++) {
			d[i][0] = cost[i][0] + Math.min(d[i-1][1], d[i-1][2]);
			d[i][1] = cost[i][1] + Math.min(d[i-1][0], d[i-1][2]);
			d[i][2] = cost[i][2] + Math.min(d[i-1][0], d[i-1][1]);
		}
		System.out.println(Math.min(Math.min(d[N - 1][0], d[N - 1][1]), d[N - 1][2]));
	}
}