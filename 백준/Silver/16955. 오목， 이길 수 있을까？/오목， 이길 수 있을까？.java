import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	static char[][] arr = new char[10][10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			String s = br.readLine();
			for (int j = 0; j < 10; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (arr[i][j] == 'X' && (isWin(i, j))) {
					System.out.println(1);
					return;
				}
			}
		}
		System.out.println(0);
	}

	private static boolean isWin(int x, int y) {
		for (int d = 0; d < dx.length; d++) {
			int cnt = 1;
			boolean isRemain = true; //. 한번만 가능
			int nx = x;
			int ny = y;
			for (int i = 0; i < 4; i++) {
				nx += dx[d];
				ny += dy[d];
				if (!isValidPos(nx, ny)) break;
				if (arr[nx][ny] == 'O') break;
				else if (arr[nx][ny] == 'X') cnt++;
				else if (arr[nx][ny] == '.' && isRemain) {
					isRemain = false;
				}
			}
			if (cnt == 4&&!isRemain) return true;
		}
		return false;
	}

	private static boolean isValidPos(int x, int y) {
		return x >= 0 && y >= 0 && x < 10 && y < 10;
	}
}