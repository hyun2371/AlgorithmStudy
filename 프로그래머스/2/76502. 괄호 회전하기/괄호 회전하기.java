import java.util.*;
class Solution {
    public int solution(String s) {
        int cnt = 0;
        for (int i=0;i<s.length();i++){
            if (isValid(s)) cnt++;
            s = s.substring(1)+s.charAt(0);
        }
    
        return cnt;
    }
    
    private boolean isValid(String s){
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()){
            //push
            if (c=='('||c=='['||c=='{') {
                stk.push(c); continue;
            }
            
            //pop
            if (stk.size()==0) return false;
            if (c==')'&&stk.pop()!='(') return false;
            if (c==']'&&stk.pop()!='[') return false;
            if (c=='}'&&stk.pop()!='{') return false;
        }
        if (stk.isEmpty()) return true;
        return false;
    }
}