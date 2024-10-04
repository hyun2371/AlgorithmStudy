import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> answer = new ArrayList<>();
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력 받기
		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		answer.add(N); // 최초 삽입
		for (int i = N - 1; i > 0; i--) {
			answer.add(arr[i], i);
		}

		// 출력
		StringBuilder sb = new StringBuilder();
		for (Integer x : answer){
			sb.append(x).append(" ");
		}
		System.out.println(sb);
	}
}