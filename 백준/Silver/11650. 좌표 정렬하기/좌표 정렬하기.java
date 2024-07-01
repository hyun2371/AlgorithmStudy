import java.util.*;

class Point{
	public int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Point> lst = new ArrayList<>();

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			lst.add(new Point(x, y));
		}

		lst.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x != o2.x)
					return o1.x - o2.x;
				return o1.y - o2.y;
			}
		});
		for (Point o : lst) {
			System.out.println(o.x + " " + o.y);
		}
	}
}