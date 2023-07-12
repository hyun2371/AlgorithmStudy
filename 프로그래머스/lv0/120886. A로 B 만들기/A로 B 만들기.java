import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String before, String after) {

       String[] beforeArr = before.split("");
        Arrays.sort(beforeArr);
        String[] afterArr = after.split("");
        Arrays.sort(afterArr);
        if (String.join("",beforeArr).equals(String.join("",afterArr)))
            return 1;
        return 0;
    }
}