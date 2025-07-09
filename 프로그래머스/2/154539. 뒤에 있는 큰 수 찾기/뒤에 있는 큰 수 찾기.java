import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stk = new Stack<>();
        for (int i=numbers.length-1;i>=0;i--){
            while (!stk.isEmpty()&&numbers[i]>=stk.peek()){
                stk.pop();
            }
            if (!stk.isEmpty()) answer[i] = stk.peek();
            else answer[i] = -1;
            stk.push(numbers[i]);
        }
        return answer;
    }
}