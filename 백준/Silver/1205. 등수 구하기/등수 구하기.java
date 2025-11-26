import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		if (N>0)
			st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int rank = N+1, sameCnt =0;
		for (int i=N-1;i>=0;i--){
			if (target>=arr[i]&&rank==N+1) rank = N-i;
			if (target==arr[i]) sameCnt++;
		}
		int answer;
		if (rank>P) answer = -1;
		else if (sameCnt>0&&rank+sameCnt>P) answer = -1;
		else answer = rank;
		System.out.print(answer);
	}
}