import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long[] d = new long[101];

		d[1] =1; d[2] = 1; d[3] = 1; d[4] = 2; d[5] = 2;

		for (int i = 6, st = 1; i <= 100; i++,st++) {
			d[i] = d[st]+d[i-1];
		}
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(d[N]).append("\n");
		}
		System.out.println(sb);
	}
}