import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] arr,ans;
	static boolean[] isVisited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		ans = new int[M];
		isVisited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		DFS(0,0);
		System.out.println(sb);
	}

	private static void DFS(int lv, int ind){
		if (lv==M){
			for (int i = 0; i <M ; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int prev = -1;
		for (int i=ind;i<N;i++){
			if (!isVisited[i]&&arr[i]!=prev){
				ans[lv] = arr[i];
				prev = arr[i];
				isVisited[i] = true;
				DFS(lv+1,i+1);
				isVisited[i] = false;
			}
		}
	}
}