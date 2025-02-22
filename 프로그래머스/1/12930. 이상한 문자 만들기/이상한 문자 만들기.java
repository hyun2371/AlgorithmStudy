import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isUpper = true;

        for (char c : s.toCharArray()){
            if (c==' ' ) {
                sb.append(' '); isUpper = true; continue;
            }
            if (isUpper) sb.append(Character.toUpperCase(c));
            else sb.append(Character.toLowerCase(c));
            isUpper = !isUpper;
        }
        return sb.toString();
    }
}