import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- >0){
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			int[] keys = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				keys[i] =  Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			for (int x: keys){
				sb.append(isExist(x)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static int isExist(int key){
		int lt = 0, rt = arr.length-1;
		while (lt<=rt){
			int mid = (lt+rt)/2;
			if (arr[mid]<key) lt = mid+1;
			else if (arr[mid]>key) rt = mid-1;
			else return 1;
		}
		return 0;
	}
}