import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 열
		int[][] arr = new int[N][N];
		int[][] d = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		d[0][0] = arr[0][0];
		int answer = d[0][0];
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j==0) d[i][j] = d[i-1][j] + arr[i][j];
				else if (j==i) d[i][j] = d[i-1][j-1] + arr[i][j];
				else d[i][j] = Math.max(d[i-1][j],d[i-1][j-1]) + arr[i][j];
				if (i==N-1)
					answer = Math.max(d[i][j], answer);
			}
		}
		System.out.println(answer);
	}
}