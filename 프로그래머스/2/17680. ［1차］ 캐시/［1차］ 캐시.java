import java.util.*;
class Solution {
    static final int HIT_TIME = 1, MISS_TIME = 5;
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize==0) return cities.length*MISS_TIME;
        
        // 캐시 초기화
        Deque<String> dq = new LinkedList<>();
        int time = 0;
        
        
        for (String city:cities){
            String key = city.toLowerCase();
            if (dq.contains(key)){ //캐시 hit
                dq.remove(key);
                dq.addLast(key);
                time+=HIT_TIME;
            } else {//캐시 miss
                if (dq.size()>=cacheSize){
                    dq.removeFirst(); //기존꺼 제거
                }
                dq.addLast(key);
                time+=MISS_TIME;
            }
        }
        return time;
    }
}