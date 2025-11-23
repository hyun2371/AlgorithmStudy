import java.util.*;
class Solution {
    public long solution(int[] weights) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int w : weights){
            map.put(w,map.getOrDefault(w,0)+1);
        }
        long answer = 0, cnt;
        for (int x : map.keySet()){
            if (map.get(x)>=2){
                cnt = (map.get(x)*(map.get(x)-1))/2;
                System.out.println(x+" "+x+" "+cnt);
                answer+=cnt;
            }
            for (int y:map.keySet()){
                if (2*x==y||3*x==2*y||4*x==3*y){
                    cnt= map.get(x)*map.get(y);
                    System.out.println(x+" "+y+" "+cnt);
                    answer+=cnt;
                }
            }
        }
       
        return answer;
    }
  
}