import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Time> times = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			times.add(new Time(s, e));
		}

        Collections.sort(times);
		int cnt = 0;
		int tmp = Integer.MIN_VALUE;
		for (Time t : times) {
			if (t.s >= tmp) {
				tmp = t.e;
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}

class Time implements Comparable<Time> {
	int s;
	int e;

	public Time(int s, int e) {
		this.s = s;
		this.e = e;
	}

	public int compareTo(Time t) {
		if (this.e == t.e)
			return this.s - t.s;
		return this.e - t.e;// 종료 시간 오름차순  1 2 (항상 음수 반환해야 함)
	}
}