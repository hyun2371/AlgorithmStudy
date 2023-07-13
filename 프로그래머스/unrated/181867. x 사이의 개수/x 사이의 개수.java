import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String myString) {
        List<Integer> lst = new ArrayList<>();
        Integer l = 0;
        for (String s : myString.split("")){
            if (s.equals("x")){
                lst.add(l);
                l=0;
            } else {
                l++;
            }
        }
       lst.add(l);
        return lst.stream().mapToInt(x->x).toArray();
    }
}