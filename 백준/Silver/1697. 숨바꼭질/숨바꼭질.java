import java.io.*;
import java.util.*;

public class Main {
	static int[] dis = new int[100_001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Arrays.fill(dis, -1);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
        
        if (N==K) {
			System.out.println(0); return;
		}
        
		System.out.println(BFS(N, K));

	}

	private static int BFS(int start, int target) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		dis[start] = 0;
		while (!q.isEmpty()) {
			int curX = q.poll(); // 현재 위치
			int[] moves = {curX - 1, curX + 1, curX * 2};
			for (int nx : moves) {
				if (nx == target) return dis[curX] + 1;
				if (nx < 0 || nx > 100_000 || dis[nx] >= 0) continue;
				dis[nx] = dis[curX] + 1;
				q.offer(nx);
			}
		}
		System.out.println(Arrays.toString(dis));
		return -1;
	}
}