import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	static int[][] graph = new int[19][19]; // -1: 흑, 0:빈칸, 1:백

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			if (i%2==0){ //흑
				graph[x][y] = -1;
				if (isWin(x,y,-1)){
					System.out.println(i+1); return;
				}
			}else {  //백
				graph[x][y] = 1;
				if (isWin(x,y,1)){
					System.out.println(i+1); return;
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean isWin(int x, int y,int color){
		for (int d=0;d<dx.length;d++){
			int cnt = 1;
			int nx = x;
			int ny = y;
			for (int i=0;i<5;i++){ // 5개 추가로 놓기 -> 6개 연속인지 판정 (cnt==6)
				nx+=dx[d];
				ny+=dy[d];
				if (!isValidPos(nx,ny)) break; // 범위
				if (graph[nx][ny]!=color) break; // 같은 색
				cnt++;
			}
			nx = x;
			ny = y;
			for (int i=0;i<5;i++){ // 역방향 탐색
				nx-=dx[d];
				ny-=dy[d];
				if (!isValidPos(nx,ny)) break; // 범위
				if (graph[nx][ny]!=color) break; // 같은 색
				cnt++;
			}
			if (cnt==5) return true;
		}
		return false;
	}

	private static boolean isValidPos(int x, int y){
		return x >= 0 && x < 19 && y >= 0 && y < 19;
	}
}