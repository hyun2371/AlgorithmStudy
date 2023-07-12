import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 1;i<=n;i++){
            if (n%i==0)
                lst.add(i);
        }
        return lst.stream().mapToInt(x->x).toArray();
    }
}