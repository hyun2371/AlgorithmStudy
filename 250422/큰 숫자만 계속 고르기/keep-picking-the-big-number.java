import java.util.*;
public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //n개 수
        int M = sc.nextInt(); //m번 작업
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            pq.offer(sc.nextInt());
        }
        while (M-->0){
            pq.offer(pq.poll()-1);
        }
        System.out.println(pq.peek());
    }
}