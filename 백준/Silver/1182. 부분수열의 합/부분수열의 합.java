import java.util.*;
import java.io.*;

public class Main {
	static int N,S,cnt;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		DFS(0, 0);
		if (S==0) cnt--; // 타겟 0일 시 공집합 제외
	    System.out.println(cnt);
	}

	private static void DFS(int lv, int total) {
		if (lv==N){
			if (total==S) {
				cnt++;
			}
			return;
		}
		DFS(lv + 1, total + arr[lv]);
		DFS(lv + 1, total);
	}
}