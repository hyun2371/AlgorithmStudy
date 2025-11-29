import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //굴다리 길이
		int M = Integer.parseInt(br.readLine()); //가로등 개수

		int[] arr = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.print(getMinH(arr, N, M));
	}

	private static int getMinH(int[] arr, int N, int M){
		for (int h=1;h<=N;h++){
			boolean flag = true;
			if (arr[0]-h>0) flag = false;
			else if (arr[M-1]+h<N) flag = false;
			else {
				for (int i=1;i<M-1;i++){
					if (arr[i]+h<arr[i+1]-h) {
						flag = false; break;
					}
				}
			}
			if (flag) return h;
		}
		return -1;
	}
}