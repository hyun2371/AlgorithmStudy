import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr,ch, ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //수열 길이 M

		arr = new int[N]; // 주어진 숫자
		ans = new int[M]; // 출력 배열
		ch = new int[N]; // arr[i] 방문여부 저장하는 ch[i]

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

		for (int i = 0; i < N; i++) {
			if (ch[i]==0){
				ans[lv] = arr[i];
				ch[i] = 1;
				DFS(lv+1);
				ch[i]=0;
			}
		}
	}
}