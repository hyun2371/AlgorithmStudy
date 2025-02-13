import java.util.*;
import java.io.*;

public class Main {
	static int F, S, G, U, D; // 총,출발,목표,위,아래
	static int[] dis; // 층별 방문 여부
	static int[] d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		dis = new int[F + 1];
		Arrays.fill(dis,-1);
		d = new int[] {U, D * -1};

		BFS();
		System.out.println(dis[G] == -1 ? "use the stairs" : dis[G]);
	}

	private static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(S);
		dis[S] = 0;
		while (!q.isEmpty()) {
			int cp = q.poll();
			for (int i = 0; i < 2; i++) {
				int np = cp + d[i];
				if (np <= 0 || np > F || dis[np]>=0) continue;
				q.offer(np);
				dis[np] = dis[cp]+1;
				if (np==G) return;
			}
		}
	}
}