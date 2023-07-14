import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] filterArr = Arrays.stream(arr).filter(x->x%divisor==0).sorted().toArray();
        
        if (filterArr.length==0) 
            return new int[]{-1};
        return filterArr;
        
    }
}