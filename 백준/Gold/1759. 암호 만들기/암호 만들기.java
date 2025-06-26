import java.util.*;
import java.io.*;

public class Main {
	static int N,M,moCnt,jaCnt;
	static char[] arr,ans;
	static StringBuilder sb = new StringBuilder();
	static Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N];
		ans = new char[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		DFS(0,0);
		System.out.println(sb);
	}
	
	private static void DFS(int lv, int start){
		if (lv==M){
			if (jaCnt<2||moCnt<1) return;
			for (int i = 0; i < M; i++) {
				sb.append(ans[i]);
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			if (set.contains(arr[i])) moCnt++;
			else jaCnt++;
			ans[lv] = arr[i];
			DFS(lv+1,i+1);
			if (set.contains(arr[i])) moCnt--;
			else jaCnt--;
		}
	}
}