import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Tower> stk = new ArrayDeque<>();
		int[] answer = new int[n];

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			while (!stk.isEmpty() && stk.peek().h < x) {
				stk.pop();
			}
			if (stk.isEmpty()) {
				answer[i] = 0;
			}
			else {
				answer[i] = stk.peek().ind;
			}
			stk.push(new Tower(x, i + 1));
		}

		StringBuilder sb = new StringBuilder();
		for (int ind : answer) {
			sb.append(ind).append(" ");
		}
		System.out.println(sb);
	}
}

class Tower {
	int h;
	int ind;

	public Tower(int h, int ind) {
		this.h = h;
		this.ind = ind;
	}
}