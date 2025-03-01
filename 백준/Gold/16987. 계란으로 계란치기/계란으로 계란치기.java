import java.util.*;
import java.io.*;

public class Main {
	static int N, cnt, maxCnt;
	static int[] s,w;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = new int[N];
		w = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			w[i] = Integer.parseInt(st.nextToken());
		}
		DFS(0,0);
		System.out.println(maxCnt);
	}

	private static void DFS(int lv, int cnt){
		if (lv==N) { //모든 계란 다 순회
			maxCnt = Math.max(cnt, maxCnt);
			return;
		}
		if (s[lv]<=0||cnt==N-1){// 들고 있는 계란 깨짐 || 들고 있는 계란 빼고 다 깨짐
			DFS(lv + 1, cnt); return;
		}
		for (int i = 0; i < N; i++) {
			if (s[i]<=0||i==lv) continue; // 이미 깨짐, 자기자신 -> 못침
			s[i] -= w[lv]; // 내구도 - 무게
			s[lv]-= w[i];

			if (s[i]<=0&&s[lv]<=0) DFS(lv+1,cnt+2); //계란 둘다 깨짐
			else if  (s[i]>0&&s[lv]>0) DFS(lv+1,cnt); // 계란 둘다 멀쩡
			else DFS(lv+1, cnt+1);//계란 둘 중 하나 깨짐

			s[i] += w[lv];
			s[lv]+= w[i];
		}
	}
}