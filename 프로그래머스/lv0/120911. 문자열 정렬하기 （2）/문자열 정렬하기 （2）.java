import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] strArr = my_string.toLowerCase().split("");
        Arrays.sort(strArr);
        for (String s : strArr){
            answer+=s;
        }
        return answer;
    }
}