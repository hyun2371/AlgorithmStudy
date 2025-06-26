import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr, answer;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visited = new boolean[N];
		answer = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		DFS(0, 0);
		System.out.println(sb);
	}

	private static void DFS(int lv, int start) {
		if (lv == M) {
			for (int x : answer) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}

		int prev = 0;
		for (int i = start; i < N; i++) {
			if (arr[i]==prev)
				continue;
			answer[lv] = arr[i];
			prev = arr[i];
			DFS(lv + 1, i);
		}
	}
}