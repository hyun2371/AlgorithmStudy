import java.util.*;
class Solution {
    public String solution(String s) {
        String answer=""; int cnt=0;
        
        for (char c : s.toCharArray()){
            if (!Character.isAlphabetic(c)){
                cnt=0;
                answer+=c;
            }
            else if (cnt%2==0){
                answer+=Character.toUpperCase(c);cnt++;
            }   
            else{
                answer+=Character.toLowerCase(c);cnt++;
            }
        }
        return answer;
    }
}