import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Nation> lst = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int ind = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lst.add(new Nation(ind, g, s, b));
		}

		Collections.sort(lst);
		int rank = 1, cnt = 1;
		for (int i = 0; i < N; i++) {
			if (i!=0){
				Nation prev = lst.get(i-1);
				Nation cur = lst.get(i);
				if (isSame(prev,cur)) cnt++; //동석차 카운트
				else {
					rank+=cnt;
					cnt = 1;
				}
			}
			if (lst.get(i).ind==K){
				System.out.println(rank); return;
			}
		}

	}

	private static boolean isSame(Nation prev, Nation cur) {
		return prev.gold==cur.gold&&prev.silver==cur.silver&&prev.bronze==cur.bronze;
	}
}

class Nation implements Comparable<Nation>{
	int ind, gold, silver, bronze;
	public Nation(int ind, int gold, int silver, int bronze) {
		this.ind = ind;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}

	@Override
	public int compareTo(Nation o) {
		if (this.gold!=o.gold) { //
			return o.gold - this.gold;
		}
		if (this.silver!=o.silver) {
			return o.silver - this.silver;
		}
		return o.bronze - this.bronze;
	}
}
