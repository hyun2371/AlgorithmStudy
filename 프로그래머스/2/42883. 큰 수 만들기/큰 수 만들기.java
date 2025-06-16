import java.util.*;

class Solution {
    public String solution(String number, int k) {

        Stack<Integer> stk = new Stack<>();
        stk.push(number.charAt(0)-'0');
        
        for (int i=1;i<number.length();i++){
            int cur = number.charAt(i)-'0';
            
            while (!stk.isEmpty()&&stk.peek()<cur&&k>0){
                stk.pop(); k--;
            }
            stk.push(cur);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int x:stk){
            sb.append(x);
        }
        
        if (k>0){
            return sb.substring(0,sb.length()-k);
        }
        
        return sb.toString();
    }
}