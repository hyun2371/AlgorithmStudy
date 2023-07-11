import java.util.stream.*;
import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
        List<String> lst = new ArrayList<>();
        for (String s : strArr){
            if (!s.contains("ad")){
                lst.add(s);
            }
        }
        return lst.toArray(String[]::new);
    }
}