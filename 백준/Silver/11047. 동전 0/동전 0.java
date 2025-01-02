import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(solution(n, k, arr));
	}

	static int solution(int n, int k, int[] arr) {
		int totalCnt = 0; // 개수 총합
		for (int i = arr.length - 1; i >= 0; i--) {
            if (k==0) break;
			if (arr[i] <= k) {
				int cnt = k / arr[i];
				totalCnt += cnt;
				k = k % arr[i];
			}
		}
		return totalCnt;
	}
}