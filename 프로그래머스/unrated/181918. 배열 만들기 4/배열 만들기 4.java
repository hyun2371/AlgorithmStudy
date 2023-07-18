import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stk = new LinkedList<>();
        int i = 0;
        
        while (i<arr.length){
            if (stk.isEmpty()){
                stk.add(arr[i++]);
            } else {
                if (stk.peekLast()<arr[i]){
                    stk.add(arr[i++]);
                } else{
                    stk.pollLast();
                }
            }
        }

        int[] answer = new int[stk.size()];
        for (int ind =0;ind<answer.length;ind++){
             answer[ind] = stk.pollFirst();
        }
        return answer;
    }
}