import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int n) {
        String[] sArr = String.valueOf(n).split("");
        int answer = 0;
        for (String s : sArr){
            answer+=Integer.parseInt(s);
        }
        return answer;
    }
}