import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr, ans;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		visited = new boolean[N];
		ans = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		DFS(0);
		System.out.println(sb);
	}

	private static void DFS(int lv) {
		if (lv == M) {
			for (int x : ans) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			if (arr[i] == tmp) continue; // 같은 레벨에서 동일한 값 선택하는거 막음

			visited[i] = true;
			ans[lv] = arr[i];
			tmp = ans[lv];
			DFS(lv + 1);
			visited[i] = false;
		}
	}
}