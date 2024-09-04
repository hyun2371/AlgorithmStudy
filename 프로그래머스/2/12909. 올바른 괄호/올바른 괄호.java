import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Integer> st = new Stack<>();
        for (char c : s.toCharArray()){
            if (c=='(') st.push(0);
            else if (c==')'){
                if (st.isEmpty()) return false;
                st.pop();
            }
        }
        if (!st.isEmpty()) return false;
        return true;
    }
}