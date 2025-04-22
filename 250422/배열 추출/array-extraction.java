import java.util.*;
public class Main {
    public static void main(String[] args) {
       
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();
       while (n-->0){
        int x = sc.nextInt();
        if (x==0){
            if (pq.isEmpty())System.out.println(0);
            else System.out.println(pq.poll());
        }
        else pq.offer(x);
       }
    }
}