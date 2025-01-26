import java.util.*;
import java.io.*;

public class Main {
	private static int[] dis = new int[100_001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Arrays.fill(dis,-1);
		if (N==K)
			System.out.println(0);
		else 
			System.out.println(BFS(N,K));
	}

	private static int BFS(int start, int target) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		dis[start] = 0;
		while (!q.isEmpty()) {
			int curX = q.poll();
			int[] nxArr = {curX-1,curX+1,curX*2};
			for (int nx : nxArr){
				if (nx<0||nx>=100001) continue;
				if (dis[nx]!=-1) continue;
				dis[nx] = dis[curX] + 1;
				if (nx==target) return dis[nx];
				q.offer(nx);
			}
		}
		return -1;
	}
}