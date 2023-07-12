import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String s) {
        String answer="";
        String[] arr = s.split("");
        Arrays.sort(arr);
        for (String v : arr){
            if (Arrays.stream(arr).filter(x->x.equals(v)).count()==1L){
                answer+=v;
            }
        }
       return answer;
        
    }
}