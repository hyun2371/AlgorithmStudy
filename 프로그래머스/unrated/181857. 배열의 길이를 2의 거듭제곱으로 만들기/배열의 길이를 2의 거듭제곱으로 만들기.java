import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> lst = new ArrayList<>();
        int n =0, l = arr.length;
        
        while (Math.pow(2,n)<l) n++;
        
        int a = (int)Math.pow(2,n)-l;
        
        
        for (int i =0;i<l;i++){//기존
            lst.add(Integer.valueOf(arr[i]));
        }
        for (int i=l;i<l+a;i++){//+a
            lst.add(0);
        }
        
        return lst.stream().mapToInt(x->x).toArray();
    }
}