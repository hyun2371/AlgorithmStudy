import java.util.*;
class Solution {
    static final int HIT_TIME = 1, MISS_TIME = 5;
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize==0) return cities.length*MISS_TIME;
        
        // 캐시 초기화
        List<String> lst = new LinkedList<>();
        int time = 0;
        
        
        for (String city:cities){
            String key = city.toLowerCase();
            if (lst.contains(key)){ //캐시 hit
                lst.remove(key);
                lst.add(key);
                time+=HIT_TIME;
            } else {//캐시 miss
                if (lst.size()>=cacheSize){
                    lst.remove(0); //기존꺼 제거
                }
                lst.add(key);
                time+=MISS_TIME;
            }
        }
        return time;
    }
}