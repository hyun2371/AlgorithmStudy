import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] a = new int[N];
			int[] b = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int l = 0; l < N; l++) {
				a[l] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < M; k++) {
				b[k] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(b);
			int total = 0;
			for (int key : a) {
				total += binarySearch(b, key);
			}
			sb.append(total).append("\n");
		}
		System.out.println(sb);
	}

	private static int binarySearch(int[] arr, int key) {

		int l = 0;
		int r = arr.length - 1;
		int result = 0;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] < key) {
				result = mid+1;
				l = mid + 1;
			} else if (arr[mid] >= key) {
				r = mid - 1;
			}
		}
		return result;
	}
}
