import java.util.*;

class Solution {
    private static int HIT_TIME=1,MISS_TIME=5;
    public int solution(int cacheSize, String[] cities) {
        int totalTime = 0;
        Deque<String> deq = new LinkedList<>();
        
        if (cacheSize==0) return MISS_TIME*cities.length;
        
        for (int i=0;i<cities.length;i++){
            String key = cities[i].toUpperCase();
            // cache hit
            if (deq.contains(key)){ 
                deq.remove(key);
                deq.addFirst(key); // 맨 뒤에 있어야지 늦게 나옴
                totalTime+=HIT_TIME;
                continue;
            }
            //cache miss
            if (deq.size()==cacheSize) deq.removeLast();
            deq.addFirst(key);
            totalTime+=MISS_TIME;
        }
        
        return totalTime;
    }
}