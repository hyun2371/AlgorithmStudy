import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		int[] d = new  int[12]; //1~12
		d[1] = 1; d[2] = 2; d[3] = 4;

		for (int i=4;i<=11;i++){
			d[i] = d[i-1]+d[i-2]+d[i-3];
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int key = Integer.parseInt(br.readLine());
			sb.append(d[key]).append("\n");
		}
		System.out.print(sb);
	}
}