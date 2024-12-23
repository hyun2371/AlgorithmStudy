import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
	static BigInteger[][] mem;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		mem = new BigInteger[n + 1][r + 1];
		System.out.println(DFS(n, r));
	}

	private static BigInteger DFS(int n, int r) {
		if (mem[n][r] != null) return mem[n][r];
		if (r == 1) return BigInteger.valueOf(n);
		if (n == r) return BigInteger.ONE;
		
		return mem[n][r] = DFS(n - 1, r - 1).add(DFS(n - 1, r));
	}
}