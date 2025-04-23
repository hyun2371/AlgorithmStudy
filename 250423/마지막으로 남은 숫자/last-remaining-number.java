import java.util.*;
public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
           pq.offer(sc.nextInt());
        }
        
        
        while(pq.size()!=1){
            int num1 = pq.poll();
            int num2 = pq.poll();
            if (num1!=num2)
                pq.offer(num1-num2);
        }
        if (pq.size()==1)
            System.out.print(pq.peek());
        else
            System.out.print(-1);
    }
}