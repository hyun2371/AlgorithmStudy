import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        if (arr.length==0) return new int[]{-1};
        
        List<Integer> lst = new ArrayList<>();
        
        for (int i =0;i<arr.length;i++)
            lst.add(Integer.valueOf(arr[i]));
        
        Arrays.sort(arr);
        
        lst.remove(Integer.valueOf(arr[0]));
        return lst.stream().mapToInt(x->x).toArray();
    }
}