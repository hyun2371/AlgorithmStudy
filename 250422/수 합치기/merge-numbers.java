import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }

        int total = 0;
        while (pq.size()!=1){
            int tmp=pq.poll()+pq.poll();
            pq.offer(tmp);
            total+=tmp;
        }
        System.out.println(total);
    }
}