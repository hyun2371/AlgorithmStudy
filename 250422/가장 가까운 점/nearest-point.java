import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            pq.offer(new Point(X,Y));
        }
        while (M-->0){
            Point p = pq.poll();
            pq.offer(new Point(p.x+2,p.y+2));
        }

        Point ans = pq.poll();
        System.out.println(ans.x+" "+ans.y);
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o){
        if ((this.x+this.y)==(o.x+o.y)){
            if (this.x==o.x) return this.y-o.y;
            return this.x-o.x;
        }
        return (this.x+this.y)-(o.x+o.y);// 오름차순
    }
}