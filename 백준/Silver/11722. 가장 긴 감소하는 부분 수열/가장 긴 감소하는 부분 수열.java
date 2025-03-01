import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N];
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		d[0] = 1;
		int answer =d[0];
		for (int i = 1; i < N; i++) {
			int prevMaxL = -1;
			for (int j = 0; j < i; j++) {
				if (arr[j]>arr[i]){ // 0~i-1에서 arr[i]보다 큰 arr값들 중 d 원소 최대값 찾음
					prevMaxL = Math.max(d[j],prevMaxL);
				}
			}
			d[i] = prevMaxL==-1?1:prevMaxL+1;
			answer = Math.max(d[i],answer);
		}
		System.out.println(answer);
	}
}