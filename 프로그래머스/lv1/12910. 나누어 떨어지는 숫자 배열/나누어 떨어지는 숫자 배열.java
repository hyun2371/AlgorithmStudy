import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> lst = new ArrayList<>();
        for (int i =0; i<arr.length;i++){
            if (arr[i]%divisor==0)
                lst.add(arr[i]);
        }
        if (lst.isEmpty()) return new int[]{-1};

        return lst.stream().mapToInt(x->x).sorted().toArray();
    }
}