import java.util.*;
class Solution {
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i=0;i<schedules.length;i++){
            if (inRange(schedules[i],timelogs[i],startday))
                answer++;
        }
        return answer;
    }
    
    private static boolean inRange(int schedule,int[] timelog, int startday){
        int h = schedule/100;
        int m = schedule%100+10;
        if (m>=60){
            h++;
            m-=60;
        }
        int limit = h*100+m;
        
        for (int i=0;i<timelog.length;i++){
            if ((startday+i)%7==6||startday+i==7) continue; //토일 제외
            if (timelog[i]>limit) return false;
        }
        return true;        
    }
}