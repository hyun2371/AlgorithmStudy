import java.util.*;
import java.io.*;

public class Main {
	static int[] zCount = new int[41];
	static int[] oCount = new int[41];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			fibo(N);
			bw.write(zCount[N] + " " + oCount[N] + "\n");
		}
		bw.flush();
		bw.close();
	}

	public static void fibo(int N) {
		zCount[0] = 1;
		oCount[0] = 0;
		zCount[1] = 0;
		oCount[1] = 1;
		for (int i=2;i<N+1;i++){
			if (zCount[i]>0) continue; // 이전에 한거 가져옴
			zCount[i] = zCount[i - 2] + zCount[i - 1];
			oCount[i] = oCount[i - 2] + oCount[i - 1];
		}
	}
}