import java.util.*;
class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        
        for (int x: topping){
            mapB.put(x,mapB.getOrDefault(x,0)+1);
        }
        
        int cnt = 0;
        for (int x : topping){
            mapA.put(x,mapA.getOrDefault(x,0)+1);
            mapB.put(x,mapB.get(x)-1);
            if (mapB.get(x)==0) mapB.remove(x);
            if (mapA.keySet().size()==mapB.keySet().size()){
                cnt++;
            }
        }
        
        return cnt;
    }
}