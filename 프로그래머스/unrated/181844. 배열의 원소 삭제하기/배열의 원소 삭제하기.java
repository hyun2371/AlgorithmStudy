import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> lst = new ArrayList<>();
        for (int n : arr){
            lst.add(n);
        }
        
        for (int n :arr){
            for (int delete : delete_list){
                if (n==delete){
                    lst.remove(Integer.valueOf(n));
                }
            }
        }

        return lst.stream().mapToInt(x->x).toArray();
    }
}