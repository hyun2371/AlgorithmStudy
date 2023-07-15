import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> lst = new ArrayList<>();
        
        for (int i =0;i<2;i++){
            for (int ind = intervals[i][0]; ind<=intervals[i][1];ind++){
                lst.add(arr[ind]);
            }
        }
        return lst.stream().mapToInt(x->x).toArray();
    }
}