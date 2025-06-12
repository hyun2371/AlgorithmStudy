import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stk = new Stack<>();
        int cnt = 0;
        for (int x : ingredient){
            stk.push(x);
            if (stk.size()>=4){
                if (stk.get(stk.size()-4)==1
                    &&stk.get(stk.size()-3)==2
                    &&stk.get(stk.size()-2)==3
                    &&stk.get(stk.size()-1)==1) {
                    cnt++;
                    for (int i=0;i<4;i++){
                        stk.pop();
                    }
                }
            }
        }
        return cnt;
    }
}