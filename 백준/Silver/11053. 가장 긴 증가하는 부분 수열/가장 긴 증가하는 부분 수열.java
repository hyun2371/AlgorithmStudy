import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dy = new int[n]; // arr[i]의 증가 수열 길이 dy[i]

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, arr, dy));
	}

	static int solution(int n, int[] arr, int[] dy) {
        if (n==1) return 1;
		int answer = 0;
		dy[0] = 1; // 첫번째 원소 증가 수열 길이는 1

		for (int i = 1; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) { // j 앞 원소들에 대해
				if (arr[j] < arr[i] && dy[j] > max) { // 현재 원소보다 작은 원소를 가진 dy[j]의 최대값
					max = dy[j];
				}
			}
			dy[i] = max + 1; // 현재 요소 증가 수열에 추가 -> 길이 + 1
			answer = Math.max(dy[i], answer); // 부분 수열 길이 갱신
		}

		return answer;
	}
}