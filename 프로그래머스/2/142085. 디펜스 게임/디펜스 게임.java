import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemies) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int round = 0;
        while (k>=0&&round<enemies.length){
            int enemyCnt = enemies[round];
            pq.add(enemyCnt);
            n-=enemyCnt;
            if (n<0){
               if (k==0) break;
               n+=pq.poll();
               k--;
            }
            round++;
        }
        
        return round;
    }
}