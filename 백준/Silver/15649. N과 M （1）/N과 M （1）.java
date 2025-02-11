import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] ch, arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M]; // 수열 길이 M
		ch = new int[N + 1];// 1~N 방문 여부 체크

		DFS(0);
		System.out.println(sb);
	}

	private static void DFS(int lv) {
		if (lv == M) {
			for (int x : arr) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {

			if (ch[i] == 0) {
				ch[i] = 1;
				arr[lv] = i;
				DFS(lv + 1);
				ch[i] = 0;
			}
		}
	}
}