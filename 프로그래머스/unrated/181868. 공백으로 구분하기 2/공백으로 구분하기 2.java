import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList<>();
        String[] arr = my_string.split(" ");
        for (String s : arr){
            if (!s.equals("")){
                list.add(s);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}