import java.util.*;
import java.io.*;

public class Main {
	static int[] arr = new int[49]; // ans에 대입할 수
	static int[] visited = new int[49]; // arr 인덱스 방문 여부
	static int[] ans = new int[6]; // 정답 배열
	static int n = -1;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (n != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			DFS(0);
            sb.append("\n");
			Arrays.fill(visited, 0);
		}
		System.out.print(sb.toString());
	}

	private static void DFS(int lv) { // lv는 정답의 인덱스
		if (lv == 6) {
			for (int x : ans){
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) { // arr의 인덱스
			if (lv > 0 && arr[i] < ans[lv - 1]) continue; // arr[i] 값이 이전 배열 값보다 작음
			if (visited[i] == 0) {
				visited[i] = 1;
				ans[lv] = arr[i];
				DFS(lv + 1);
				visited[i] = 0;
			}
		}
	}
}