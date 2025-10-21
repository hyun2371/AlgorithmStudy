import java.util.*;
class Solution {
    static int totalT;
    static Queue<String> q = new LinkedList<>();
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize==0)
            return cities.length*5;
        for (String key : cities){
            search(cacheSize, key.toLowerCase());
        }
        return totalT;
    }
    
    private static void search(int cacheSize, String key){
        if (q.contains(key)) {
            totalT++;
            q.remove(key);
            q.offer(key);
        }
        else {
            if (q.size()<cacheSize){
                q.offer(key);
            }
            else {
                q.poll();
                q.offer(key);
            }
            totalT+=5;
        }
    }
}