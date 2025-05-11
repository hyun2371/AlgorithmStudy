import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<s.length();i++){
            sb.append(convert(s.charAt(i),skip,index));
        }
        return sb.toString();
    }
    
    private static char convert(char c, String skip, int index){
        while (index-->0){
            c = (char)(c+1);
            if (c>'z') c = 'a';
            if (skip.contains(String.valueOf(c))) index++;
        }
        return c;
    }
}