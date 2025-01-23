import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (x<y){
				int tmp = x;
				x =y;
				y = tmp;
			}
			bw.write(gcd(x,y)+"\n");
		}
		bw.flush();
		bw.close();
	}
	public static int gcd(int x, int y) {
		if (y == 0) return x;
		return gcd(y, x % y);
	}
}