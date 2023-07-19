import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> lst = new ArrayList<>();
        for (int i=2;i<=n;i++){
            if (n%i==0){
                while (n%i==0){
                    n/=i;
                }
                lst.add(i);
            }
        }
        return lst.stream().mapToInt(x->x).toArray();
    }
}