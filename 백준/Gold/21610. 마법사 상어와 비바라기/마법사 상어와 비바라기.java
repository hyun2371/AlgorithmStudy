import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[][] graph;//물 높이 저장
	static int N, M;
	static boolean[][] visited;
	static Queue<Pos> clouds = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 명령어 수
		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		initCloud();

		for (int i = 0; i < M; i++) { //M개 명령어 읽기
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			run(d, s); // 명령어 수행
		}

		int total=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				total+=graph[i][j];
			}
		}
		System.out.println(total);
	}

	private static void initCloud() {
		clouds.offer(new Pos(N - 2, 0));
		clouds.offer(new Pos(N - 2, 1));
		clouds.offer(new Pos(N - 1, 0));
		clouds.offer(new Pos(N - 1, 1));
	}

	private static void run(int d, int s) {
		step12(d,s);
		step34();
		step5();
	}

	private static void step12(int d, int s) {
		for (Pos cloud : clouds) {
			cloud.x = tunning(cloud.x + dx[d] * s);
			cloud.y = tunning(cloud.y + dy[d] * s);
			graph[cloud.x][cloud.y]++;
		}
	}

	private static void step34() {
		visited = new boolean[N][N];
		while (!clouds.isEmpty()) {
			Pos cloud = clouds.poll();
			int cnt = 0;
			for (int d = 1; d < 8; d += 2) {
				int nx = cloud.x+dx[d];
				int ny = cloud.y+dy[d];
				if (inRange(nx,ny)&&graph[nx][ny]>=1) cnt++;
			}
			graph[cloud.x][cloud.y]+=cnt;
			visited[cloud.x][cloud.y] = true;
		}
	}

	private static void step5(){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j]>=2&&!visited[i][j]) {
					clouds.offer(new Pos(i, j));
					graph[i][j]-=2;
				}
			}
		}
	}
	private static boolean inRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

	private static int tunning(int num) {
		return ((num % N) + N) % N;
	}
}

class Pos {
	int x, y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}