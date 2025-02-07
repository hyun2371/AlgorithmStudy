import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] c = new int[N + 1];
		for (int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(br.readLine());
		}

		int cnt = 0, ind = N-1;
		while (K > 0) {
			cnt += K / c[ind];
			K %= c[ind--];
		}
		System.out.println(cnt);
	}
}