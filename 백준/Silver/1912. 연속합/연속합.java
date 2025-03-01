import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] d = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		d[0] = arr[0];
		int answer = d[0];
		for (int i = 1; i < N; i++) {
			d[i] = Math.max(d[i - 1], 0)+arr[i];
			answer = Math.max(d[i], answer);
		}
		System.out.println(answer);
	}
}