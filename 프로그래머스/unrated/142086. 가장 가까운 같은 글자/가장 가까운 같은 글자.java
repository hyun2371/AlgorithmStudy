import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alpha = new int[26];
        
        for (int i=0;i<s.length();i++){
            if (i==s.indexOf(s.charAt(i))){
                answer[i] = -1;
                alpha[s.charAt(i)-'a'] = i;
            }
                
            else {
                answer[i] = i-alpha[s.charAt(i)-'a'];
                alpha[s.charAt(i)-'a'] = i;
            }
        }
        return answer;
    }
}