import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[] d = new long[101];
		d[1] = 1; d[2] = 1; d[3] = 1;
		for (int i = 4; i <= 100; i++) {
			d[i] = d[i-2]+d[i-3];
		}

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			sb.append(d[k]).append("\n");
		}
		System.out.print(sb);
	}
}    