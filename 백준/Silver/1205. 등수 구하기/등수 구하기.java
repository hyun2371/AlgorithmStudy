import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		if (N==0){
			System.out.print(1); return;
		}
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int rank = 1;
		for (int i = 0; i < N; i++) {
			if (arr[i]>target) rank++;
			else break;
		}
        
        if ((rank>P)||N>=P&&target<=arr[P-1]){
			System.out.print(-1);
			return;
		}
		System.out.print(rank);
	}
}