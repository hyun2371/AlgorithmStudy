import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<progresses.length;i++){
            int remain = 100-progresses[i];
            if (remain%speeds[i]==0) 
                q.offer(remain/speeds[i]);
            else
                q.offer(remain/speeds[i]+1);
        }
        
        int cnt = 1;
        int cur = q.poll();
        while (!q.isEmpty()){
            if (q.peek()<=cur){
                q.poll();
                cnt++;
            } else {
                answer.add(cnt);
                cnt=1;
                cur = q.poll();
            } 
        }
        answer.add(cnt);
        return answer;
    }
}