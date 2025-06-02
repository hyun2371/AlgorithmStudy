import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0, lt =0, answer=0;
		for (int rt = 0; rt < N; rt++) {
			if (arr[rt]%2==1) K--;
			else cnt++;
			while (K<0){
				if (arr[lt]%2==1) K++;
				else cnt--;
				lt++;
			}
			answer = Math.max(cnt,answer);
		}
		System.out.println(answer);
	}
}