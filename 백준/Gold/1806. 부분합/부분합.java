import java.io.*;
import java.util.*;

public class Main {
	static int N, S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 개수
		S = Integer.parseInt(st.nextToken()); // 목표 합
		int[] a = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(a));
	}

	private static int solution(int[] a) {
		int lt = 0, rt = 0;
		int sum = a[lt];
		int ml = Integer.MAX_VALUE;

		while (lt <= rt) {
			if (sum < S) {
				if (rt + 1 == N) break;
				rt++;
				sum += a[rt];
			} else {
				ml = Math.min(ml, rt - lt + 1);
				sum -= a[lt];
				lt++;
			}

		}
		if (ml == Integer.MAX_VALUE) ml = 0;
		return ml;
	}
}