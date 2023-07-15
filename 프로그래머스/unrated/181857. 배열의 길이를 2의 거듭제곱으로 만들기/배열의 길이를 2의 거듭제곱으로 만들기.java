import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        /*
        Math.pow(2,n) l = arr.length
        n++ l++
        while (Math.pow(2,n)<l)
            n++
        
        k = l - Math.pow(2,n)
        */
        List<Integer> lst = new ArrayList<>();
        int n =0, l = arr.length;
        while (Math.pow(2,n)<l){
            n++;
        }
        int a = (int)Math.pow(2,n)-l;
        
        for (int i =0;i<l;i++){
            lst.add(Integer.valueOf(arr[i]));
        }
        for (int i=l;i<l+a;i++){
            lst.add(0);
        }
        return lst.stream().mapToInt(x->x).toArray();
           
    }
}