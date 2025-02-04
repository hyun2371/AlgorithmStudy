import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 주어지는 숫자 개수
		int M = Integer.parseInt(st.nextToken()); // 구하는 횟수

		int[] d = new int[N+1];
		d[0] = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			d[i] = d[i-1]+ cur;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 시작 인덱스
			int e = Integer.parseInt(st.nextToken()); // 끝 인덱스
			sb.append(d[e]-d[s-1]).append("\n");
		}
		System.out.println(sb);
	}
}