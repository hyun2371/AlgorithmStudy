import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> answer = new ArrayList<>();
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		answer.add(N);
		for (int i = N - 1; i > 0; i--) {
			answer.add(arr[i], i);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (Integer x : answer) {
			bw.write(x + " ");
		}
		bw.flush();
	}
}