import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			set.add(word);
		}

		StringBuilder sb = new StringBuilder();
		while (m-- >0){
			String[] arr = br.readLine().split(",");
			for (int i = 0; i < arr.length; i++) {
				if (set.contains(arr[i])) set.remove(arr[i]);
			}
			sb.append(set.size()).append("\n");
		}
		System.out.print(sb);
	}

}