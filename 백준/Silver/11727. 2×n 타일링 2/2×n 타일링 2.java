import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N + 1];

		d[1] = 1;
		if (N>1){
			d[2] = 3;
			for (int i = 3; i <= N; i++) {
				d[i] = (2*d[i-2]+d[i-1])%10_007;
			}
		}
		
		System.out.println(d[N]);
	}
}