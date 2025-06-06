import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			sb.append(ho(arr)).append("\n");
		}
		System.out.print(sb);
	}

	private static long ho(int[] arr) {
        int n = arr.length, max = 0;
        long total = 0;

		for (int i=n-1;i>=0;i--){
			if (arr[i]>max){
				max = arr[i];
			} else {
				total+=(max-arr[i]);
			}
		}
		return total;
	}
}