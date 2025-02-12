import java.util.*;
import java.io.*;

public class Main {
	static int n, cnt;
	static boolean[] ch1, ch2, ch3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ch1 = new boolean[n];
		ch2 = new boolean[2 * n - 1];
		ch3 = new boolean[2 * n - 1];
		DFS(0);
		System.out.println(cnt);
	}

	private static void DFS(int lv) { // lv:행
		if (lv == n) {
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) { // i: 열
			if (ch1[i] || ch2[lv+i] || ch3[lv - i + n - 1]) continue;
			ch1[i] = true;
			ch2[lv+i] = true;
			ch3[lv - i + n - 1] = true;
			DFS(lv + 1);
			ch1[i] = false;
			ch2[lv+i] = false;
			ch3[lv - i + n - 1] = false;
		}
	}
}