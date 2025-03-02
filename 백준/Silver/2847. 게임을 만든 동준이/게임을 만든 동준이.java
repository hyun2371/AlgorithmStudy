import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int cnt = 0;

		for (int i = 1; i < N; i++) {
			while (arr[N - i] <= arr[N - i - 1]) {
				arr[N - i - 1]--;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}