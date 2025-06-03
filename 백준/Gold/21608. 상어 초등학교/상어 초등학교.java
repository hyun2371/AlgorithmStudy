import java.io.*;
import java.util.*;

public class Main{
	static int N, studentCnt, targetCnt=4;
	static int[][] seats;
	static Map<Integer, HashSet<Integer>> map = new HashMap<>();
	static int[] order;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static Queue<Pos> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		studentCnt = N*N;
		order = new int[studentCnt];
		seats = new int[N][N]; //좌석표

		for (int i = 0; i < studentCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int keyStudent = Integer.parseInt(st.nextToken());
			order[i] = keyStudent;
			HashSet<Integer> likes = new HashSet<>();
			for (int j = 0; j < targetCnt; j++) {
				int like = Integer.parseInt(st.nextToken());
				likes.add(like);
			}
			map.put(keyStudent, likes);
		}

		place();
		System.out.println(calculate());
	}


	private static void place(){ //좌석 배치
		seats[1][1] =order[0];
		for (int i=1;i<studentCnt;i++){//2번째~N*N학생
			pq = new PriorityQueue<>();
			int keyStudent = order[i];
			for (int r=0;r<N;r++){//선점 안된 최적의 좌석 찾기
				for (int c=0;c<N;c++){
					if (seats[r][c]==0) search(r,c,keyStudent);
				}
			}
			Pos pos = pq.poll();
			seats[pos.x][pos.y] = keyStudent;
		}
	}

	private static void search(int x, int y,int keyStudent){ //후보에 자리 추가
		int likeCnt=0, emptyCnt =0;
		for (int d = 0; d < dx.length; d++) {//인접한 칸 탐색
			int nx = x+dx[d];
			int ny = y+dy[d];
			if (!inRange(nx,ny)) continue;
			if (seats[nx][ny]>0) { //인접한 행에 선호학생 확인
				if(map.get(keyStudent).contains(seats[nx][ny])) likeCnt++;
			}
			else emptyCnt++; //자리가 비어있음
		}
		pq.add(new Pos(x,y, likeCnt, emptyCnt));
	}

	private static int calculate(){
		int total =0;
		for (int r=0;r<N;r++) {
			for (int c = 0; c < N; c++) {
				int likeCnt = 0;
				for (int d = 0; d < 4; d++) {//인접한 칸 탐색
					int nx = r + dx[d];
					int ny = c + dy[d];
					if (!inRange(nx, ny)) continue;
					if(map.get(seats[r][c]).contains(seats[nx][ny])) likeCnt++;
				}
				total += getLikeScore(likeCnt);
			}
		}

		return total;
	}

	private static int getLikeScore(int likeCnt){
		if (likeCnt==0) return 0;
		if (likeCnt==1) return 1;
		if (likeCnt==2) return 10;
		if (likeCnt==3) return 100;
		return 1000;
	}

	private static boolean inRange(int x,int y){
		return x>=0&&y>=0&&x<N&&y<N;
	}
}

class Pos implements Comparable<Pos>{
	int x;
	int y;
	int likeCnt;
	int emptyCnt;

	public Pos(int x, int y, int likeCnt, int emptyCnt) {
		this.x = x;
		this.y = y;
		this.likeCnt = likeCnt;
		this.emptyCnt = emptyCnt;
	}
	//likeCnt 내림차순, emptyCnt 내림차순, x오름차순,y오름차순
	public int compareTo(Pos o){
		if (o.likeCnt!=this.likeCnt) return o.likeCnt-this.likeCnt;
		if (o.emptyCnt!=this.emptyCnt) return o.emptyCnt-this.emptyCnt;
		if (o.x!=this.x) return this.x-o.x;
		else return this.y-o.y;
	}
}