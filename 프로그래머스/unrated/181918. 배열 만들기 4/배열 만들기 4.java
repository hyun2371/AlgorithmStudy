import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        
        List<Integer> stk = new ArrayList<>();
        int i=0;
        while (i<arr.length){
                if (stk.size()==0){
                stk.add(arr[i++]);
            } else {
                if (stk.get(stk.size()-1)<arr[i]){
                    stk.add(arr[i++]);
                } else {
                    stk.remove(stk.size()-1);
                }
            }
        }
        
        return stk.stream().mapToInt(x->x).toArray();
    }
}