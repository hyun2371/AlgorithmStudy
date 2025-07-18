import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        sb.append(Character.toUpperCase(s.charAt(0)));
        
        for (int i=1;i<s.length();i++){
            if (s.charAt(i-1)==' ')
                sb.append(Character.toUpperCase(s.charAt(i)));
            else sb.append(s.charAt(i));
        }
       
        return sb.toString();
    }
}