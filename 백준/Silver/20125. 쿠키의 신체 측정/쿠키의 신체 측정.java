import java.util.*;
import java.io.*;

public class Main {
	static int heart_r, heart_c,waist_r, waist_c,n;
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		for (int i=0;i<n;i++){
			String line = br.readLine();
			for (int j=0;j<n;j++){
				arr[i][j] = line.charAt(j);
			}
		}

		getHeart();

		StringBuilder sb = new StringBuilder();
		sb.append(heart_r+1).append(" ").append(heart_c+1).append("\n");
		sb.append(getLeftArm(heart_r,heart_c-1)).append(" ");
		sb.append(getRightArm(heart_r,heart_c+1)).append(" ");
		sb.append(getWaist(heart_r+1,heart_c)).append(" ");
		sb.append(getLeg(waist_r+1,waist_c-1)).append(" ");
		sb.append(getLeg(waist_r+1,waist_c+1));
		System.out.print(sb);
	}

	private static void getHeart(){
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				if (arr[i][j]=='*'){
					heart_r = i+1; heart_c = j;
					return;
				}
			}
		}
	}

	private static int getWaist(int r, int c){
		int len = 0;
		while (r<n&&arr[r][c]=='*'){
			len++;
			r++;
		}
		waist_r = r-1; waist_c = c;
		return len;
	}

	private static int getLeftArm(int r, int c){
		int len = 0;
		while (c>=0&&arr[r][c]=='*'){
			len++;
			c--;
		}
		return len;
	}

	private static int getRightArm(int r, int c){
		int len = 0;
		while (c<n&&arr[r][c]=='*'){
			len++;
			c++;
		}
		return len;
	}

	private static int getLeg(int r, int c){
		int len = 0;
		while (r<n&&c<n&&arr[r][c]=='*'){
			len++;
			r++;
		}
		return len;
	}
}