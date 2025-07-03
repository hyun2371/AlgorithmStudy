import java.util.*;
class Solution {
    public int solution(String s) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i=0;i<s.length();i++){
            sb = new StringBuilder(sb);
            String tmp = sb.substring(0,1);
            sb.deleteCharAt(0);
            sb.append(tmp);
            if (isValid(sb.toString())) cnt++;
            s = sb.toString();
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