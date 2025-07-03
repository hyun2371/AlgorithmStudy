import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        Queue<Long> pq = new PriorityQueue<>();
        for (long x : scoville){
            pq.offer(x);
        }
        while(true){
            if (pq.peek()>=K) break; // 모든 음식 스코빌 지수 k이상
            if (pq.size()<=1) return -1; //더 이상 섞을 수 없음
            long n1 = pq.poll();
            long n2 = pq.poll();
            pq.offer(n1+n2*2);
            cnt++;
        }
        return cnt;
    }
}