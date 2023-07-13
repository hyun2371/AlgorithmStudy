import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> lst = new ArrayList<>();
        
        for (int i =0;i<flag.length;i++){
            if (flag[i]){
                for (int j =1;j<=arr[i]*2;j++){
                    lst.add(arr[i]);
                }
            } else {
                for (int j =0;j<arr[i];j++){
                    lst.remove(lst.size()-1);
                }
            }
        }
        
        return lst.stream().mapToInt(x->x).toArray();
    }
}