import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1=0, sum2=0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int x : queue1){
            q1.offer(x);
            sum1+=x;
        }
        for (int x : queue2){
            q2.offer(x);
            sum2+=x;
        }
        
        if ((sum1+sum2)%2==1)return -1;
        int cnt = 0;
        long target = (sum1+sum2)/2;
        int limit = (q1.size()+q2.size())*2;
        while (cnt<limit){
            if (sum1==target) {
                return cnt;
            }
            else if (sum1<target){
                int tmp = q2.poll();
                q1.offer(tmp);
                sum1+=tmp;
            }
            else if (sum1>target){
                int tmp = q1.poll();
                q2.offer(tmp);
                sum1-=tmp;
            }
            cnt++;
        }
        
        return -1;
    }
}