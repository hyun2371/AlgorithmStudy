import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> lst = new ArrayList<>();
        lst.add(n);
        while (n!=1){
            n = n%2==0?n/2:3*n+1;
            lst.add(n);
        }
        return lst.stream().mapToInt(x->x).toArray();
        
    }
}