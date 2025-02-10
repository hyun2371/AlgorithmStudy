import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(a);
		int maxW = Integer.MIN_VALUE;
		for (int i =1; i <=N; i++) {
			maxW = Math.max(a[N - i] * i, maxW);
		}
		System.out.println(maxW);
	}
}