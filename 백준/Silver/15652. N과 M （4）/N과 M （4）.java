import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M]; // 수열 길이 M

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
			if (lv > 0 && i < arr[lv-1]) continue; // 현재 넣으려는 원소가 이전 원소보다 작으면
			arr[lv] = i;
			DFS(lv + 1);
		}
	}
}