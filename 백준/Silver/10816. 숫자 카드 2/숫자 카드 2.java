import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Map<Integer, Integer> map = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int key;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			key = Integer.parseInt(st.nextToken());
			map.put(key,map.getOrDefault(key,0)+1);
		}
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			key = Integer.parseInt(st.nextToken());
			if (map.get(key)==null)
				sb.append(0).append(" ");
			else sb.append(map.get(key)).append(" ");
		}
		System.out.print(sb);
	}
}