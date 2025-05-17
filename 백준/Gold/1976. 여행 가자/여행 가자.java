import java.util.*;
import java.io.*;

public class Main {
	static int[] uf;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] graph = new int[N][N];
		uf = new int[N+1];
		for (int i = 1; i <= N; i++) {
			uf[i] = i;
		}

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (graph[i][j]==1)
					union(i+1,j+1);
			}
		}

		st = new StringTokenizer(br.readLine());
		int setNum = find(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < M; i++) {
			int tmpSetNum = find(Integer.parseInt(st.nextToken()));
			if (tmpSetNum != setNum) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	private static void union(int v1, int v2){
		int x = find(v1);
		int y = find(v2);
		if (x!=y) uf[x] = y;
	}

	private static int find(int v){
		if (v==uf[v]) return v;
		return uf[v] = find(uf[v]);
	}
}