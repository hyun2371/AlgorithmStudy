import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		List<Point> points = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new Point(x, y));
		}
		Collections.sort(points);

		StringBuilder sb = new StringBuilder();
		for (Point point : points) {
			sb.append(point.x).append(" ").append(point.y).append("\n");
		}
		System.out.println(sb);
	}
}

class Point implements Comparable<Point>{
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point p) {
		if (this.y==p.y) return this.x-p.x;
		return this.y-p.y;
	}
}