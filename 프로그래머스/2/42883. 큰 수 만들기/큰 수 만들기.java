import java.util.*;

class Solution {
    public String solution(String number, int k) {

        Stack<Character> stk = new Stack<>();
        
        for (int i=0;i<number.length();i++){
            char cur = number.charAt(i);
            
            while (!stk.isEmpty()&&stk.peek()<cur&&k>0){
                stk.pop(); k--;
            }
            stk.push(cur);
        }
        while (k-->0) stk.pop();
        
        StringBuilder sb = new StringBuilder();

        for (char c : stk){
            sb.append(c);
        }
        
        return sb.toString();
    }
}