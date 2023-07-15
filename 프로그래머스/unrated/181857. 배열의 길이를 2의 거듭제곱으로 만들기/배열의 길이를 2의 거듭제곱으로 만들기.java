import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int l = 1;
        while (l<arr.length){
            l*=2;
        }
        
        int[] answer = new int[l];
        
        for (int i =0;i<arr.length;i++){
            answer[i] = arr[i];
        }
        return answer;
    }
}