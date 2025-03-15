import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			char[] cArr = br.readLine().toCharArray();
			Arrays.sort(cArr);
			set.add(String.valueOf(cArr));
		}
		System.out.println(set.size());
	}
}