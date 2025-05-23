import java.util.*;
import java.io.*;

public class Main {
	static int R, C, ur, uc, dr, dc;
	static int[][] arr;
	static int[][] tmp;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static int[] dx2 = {0,1,0,-1};
	static int[] dy2 = {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];

		List<Integer> startR = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j]==-1) {
					startR.add(i);
				}
			}
		}

		for (int i = 0; i < T; i++) {
			spread();
			move(startR.get(0),dx,dy);
			move(startR.get(1),dx2,dy2);
		}

		int total =2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				total+=arr[i][j];
			}
		}
		System.out.println(total);
	}

	private static void spread(){
		tmp = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j]>=5){
					spread(i,j);
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				arr[i][j]+=tmp[i][j];
			}
		}

	}
//현 위치의 범위안에 있고 공청기 없는상하좌우 개수 셈
	// 현위치 5로 나눈 값을 더해줌
	private static void spread(int x, int y){
		int spreadAmount = arr[x][y]/5;
		int spreadCnt=0;
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d] ;
			int ny = y+dy[d];
			if (inRange(nx,ny)&&arr[nx][ny]!=-1) {
				tmp[nx][ny] += spreadAmount;
				spreadCnt++;
			}
		}
		arr[x][y] -= (arr[x][y]/5)*spreadCnt;
	}

	private static boolean inRange(int x, int y){
		return x>=0&&x<R&&y>=0&&y<C;
	}

	private static void move(int startX, int[] dx, int[] dy){
		int cx = startX, cy = 1;
		int prev = arr[cx][cy], dirNum = 0;
		while(true){
			int nx = cx+dx[dirNum];
			int ny = cy+dy[dirNum];
			if (!inRange(nx,ny)){ //범위 벗어나면 방향 바꿈
				dirNum++;
				continue;
			}
			if (arr[nx][ny]==-1) break; // 공기청정기로 돌아오면 종료

			int tmp = arr[nx][ny]; // 바꿀 위치값 백업
			arr[nx][ny] = prev; // 바꿀 위치값에 예전에 백업한 값 넣기
			prev = tmp; //지금 백업한 값 업데이트

			cx = nx;
			cy = ny;
		}
		arr[startX][1] = 0;
	}
}