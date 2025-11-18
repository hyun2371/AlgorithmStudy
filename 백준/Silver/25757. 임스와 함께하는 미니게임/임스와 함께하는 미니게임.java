import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char C = st.nextToken().charAt(0);

		int k;
		if (C=='Y') k=1;
		else if (C=='F') k=2;
		else k=3;

		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		System.out.print(set.size()/k);
	}
}