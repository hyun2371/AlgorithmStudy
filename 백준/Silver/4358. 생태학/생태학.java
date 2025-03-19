import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new TreeMap<>();
		String s;
		int size = 0;
		while ((s = br.readLine()) != null) {
			map.put(s, map.getOrDefault(s, 0) + 1);
			size++;
		}

		for (String k : map.keySet()) {
			double p = map.get(k) * 1.0 / size * 100;
			System.out.printf("%s %.4f\n", k, p);
		}
	}
}