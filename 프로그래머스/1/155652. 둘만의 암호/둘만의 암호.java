import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        
        StringBuilder sb = new StringBuilder();
        Set<Character> skipSet = new HashSet();
        for (char c : skip.toCharArray()){
            skipSet.add(c);
        }
        
        for (char c : s.toCharArray()){
            sb.append(convert(c, skipSet, index));
        }        
        
        return sb.toString();
    }
    
    private static char convert(char c, Set<Character> skipSet, int index){
        int cnt = 0;
        while (cnt<index){
            c = (char)(c+1);
            if (c>'z') c='a';
            if (skipSet.contains(c)) continue;
            cnt++;
        }
        return c;
        
    }

}