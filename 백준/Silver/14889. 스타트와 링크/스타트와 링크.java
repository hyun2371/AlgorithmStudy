import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static boolean[] vis;
	static int N, answer = Integer.MAX_VALUE, score1, score2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 열
		arr = new int[N][N];
		vis = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0,0);
		System.out.println(answer);
	}

	private static void DFS(int lv, int ind) {
		if (lv == N/2) {
			calculate();
			return;
		}
		for (int i = ind; i < N; i++) {
			if (vis[i]) continue;
			vis[i] = true;
			DFS(lv+1,i+1);
			vis[i] = false;
		}
	}

	private static void calculate() {
		score1 = 0;score2 = 0;
		for (int i=0;i<N-1;i++){
			for (int j=i+1;j<N;j++){
				if (vis[i]&&vis[j])
					score1+=arr[i][j]+arr[j][i];
				else if (!vis[i]&&!vis[j])
					score2+=arr[i][j]+arr[j][i];
			}
		}
		answer = Math.min(answer, Math.abs(score1-score2));
        if (answer==0) {
			System.out.println(0);
			System.exit(0);
		}
	}
}