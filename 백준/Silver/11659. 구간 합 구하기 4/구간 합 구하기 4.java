import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int tries = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];
		arr[0] = 0;
		int[] answer = new int[tries];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i + 1] = arr[i] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < tries; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			answer[i]=arr[e] - arr[s - 1];
		}

		for (int x: answer) {
			System.out.println(x);
		}
	}
}