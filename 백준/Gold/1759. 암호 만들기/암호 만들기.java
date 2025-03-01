import java.util.*;
import java.io.*;

public class Main {
	static int L,C;
	static char[] arr, ans;
	static boolean[] vis;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); //정답 길이
		C = Integer.parseInt(st.nextToken()); //주어진 수 개수

		arr = new char[C];
		vis = new boolean[C];
		ans = new char[L];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);

		DFS(0);
		System.out.println(sb);
		String s = "aiou";
	}

	static void DFS(int lv){
		if (lv==L){
			if (!satisfy(ans)) return;
			for (char x : ans){
				sb.append(x);
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < C; i++) {
			if (vis[i]) continue;
			if (lv>0&&ans[lv-1]>arr[i]) continue; // 오름차순
			ans[lv] = arr[i];
			vis[i] = true;
			DFS(lv+1);
			vis[i] = false;
		}
	}

	static boolean satisfy(char[] ans){
		int jCnt = 0, mCnt = 0;
		for (char x : ans){
            if (x=='a'||x=='e'||x=='i'||x=='o'||x=='u') mCnt++;
            else jCnt++;
		}
		return mCnt >= 1 && jCnt >= 2;
	}
}