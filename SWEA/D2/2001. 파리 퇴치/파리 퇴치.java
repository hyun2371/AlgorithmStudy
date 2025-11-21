import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int ind = 1;
		while (T-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#").append(ind++).append(" ").append(getMaxScore(arr,n,m)).append("\n");
		}
		System.out.print(sb);
	}

	private static int getMaxScore(final int[][] arr, int n, int m){
		int maxScore = 0;
		for (int i = 0; i < n-m+1; i++) {
			for (int j = 0; j < n-m+1; j++) {
				int score = 0;
				for (int k = 0; k < m; k++) {
					for (int l = 0; l < m; l++) {
						score+=arr[i+k][j+l];
					}
				}
				maxScore = Math.max(maxScore, score);
			}
		}
		return maxScore;
	}
}
