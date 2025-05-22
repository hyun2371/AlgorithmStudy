import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[] visited;
	static List<Pos> chickList = new ArrayList<>(); // 모든 치킨 집 좌표
	static List<Pos> houseList = new ArrayList<>();
	static int[] chickIndArr; // 선택된 치킨집 배열 조합
	static int answer = Integer.MAX_VALUE; // 도시 치킨 거리 최소값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j]==1)
					houseList.add(new Pos(i,j));
				else if (graph[i][j]==2) // 치킨집 리스트에 추가
					chickList.add(new Pos(i,j));
			}
		}
        
        visited = new boolean[chickList.size()];
		chickIndArr = new int[M];

		DFS(0,0);
		System.out.println(answer);
	}

	// 치킨 집 인덱스들 중 M개 조합 구하기
	private static void DFS(int lv, int ind) {
		if (lv==M){
			answer = Math.min(answer,getTotalDis());
			return;
		}
		for (int i = ind; i < chickList.size(); i++) {
			if (!visited[i]){
				visited[i] = true;
				chickIndArr[lv] = i;
				DFS(lv+1, i+1);
				visited[i] = false;
			}

		}
	}

	private static int getTotalDis(){
		int totalDis = 0;
		for (Pos housePos : houseList){
			int minDis = Integer.MAX_VALUE;
			for (int chickInd: chickIndArr){
				Pos chickPos = chickList.get(chickInd);
				minDis = Math.min(getDis(housePos, chickPos), minDis);
			}
			totalDis+=minDis;
		}
		return totalDis;
	}

	// 집과 치킨 집 사이 거리
	private static int getDis(Pos house, Pos chick){
		return Math.abs(house.x-chick.x)+Math.abs(house.y-chick.y);
	}
}

class Pos {
    int x,y;
    public Pos(int x,int y){
        this.x = x;
        this.y = y;
    }
}