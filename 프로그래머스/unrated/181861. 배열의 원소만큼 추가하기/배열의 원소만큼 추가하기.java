import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> lst = new ArrayList<>();
        for (int n : arr){
            for (int i = 0 ;i<n;i++){
                lst.add(n);
            }
        }
        return lst.stream().mapToInt(Integer::intValue).toArray();
    }
}