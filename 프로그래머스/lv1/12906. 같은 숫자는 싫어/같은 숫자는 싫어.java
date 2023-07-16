import java.util.*;
import java.util.stream.*;
public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> lst = new ArrayList<>();

    
        stack.push(arr[0]);
        lst.add(arr[0]);
        for (int i =0;i<arr.length;i++){
            if (stack.peek()!=arr[i]){
                stack.push(arr[i]);
                lst.add(arr[i]);
            }     
        }

        return lst.stream().mapToInt(x->x).toArray();
    }
}