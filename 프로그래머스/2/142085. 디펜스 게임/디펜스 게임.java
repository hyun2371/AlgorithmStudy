import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int cnt = 0;
        long remain = n;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i=0;i<enemy.length;i++){
            pq.offer(enemy[i]);
            remain-=enemy[i];
            if (remain<0){
                if (k==0) break;
                remain+=pq.poll();
                k--;
            }
            cnt++;
        }
        return cnt;
    }
}