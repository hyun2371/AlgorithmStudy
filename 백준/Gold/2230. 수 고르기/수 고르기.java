import java.io.*;
import java.util.*;


public class Main {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 개수
		M = Integer.parseInt(st.nextToken()); // 차이
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		Arrays.sort(arr);

		int answer = Integer.MAX_VALUE;
		int lt = 0;
		int rt = lt+1;

		while (rt<N){ 
			int diff = arr[rt]-arr[lt];
			if (diff<M) rt++; 
			else {
				answer = Math.min(answer, diff);
				if (answer==M) break;
				lt++;
			}
		}
		return answer;
	}
}
/**
 * rt>=N이면 break하는 이유
 * rt가 배열 끝에 다다르면 M이 더이상 증가할 수 없음
 */