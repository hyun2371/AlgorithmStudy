import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] d = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		d[0] = arr[0];
		int answer = Integer.MIN_VALUE;
		for (int i = 1; i < N; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					max = Math.max(d[j], max);
				}
			}
			if (max == Integer.MIN_VALUE) d[i] = arr[i];
			else d[i] = max + arr[i];
			answer = Math.max(d[i], answer);
		}
        answer = Math.max(answer,d[0]);
		System.out.println(answer);
	}
}