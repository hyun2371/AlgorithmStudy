import java.util.stream.*;
import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        /*
        여부 확인해 arr에 1넣기
        arr 순회하며 0이면 더하기
        */
        int answer=0;
        int[] arr = new int[10];
        for (int i =0;i<numbers.length;i++){
            arr[numbers[i]] = 1;
            
        }
        for (int i =0;i<arr.length;i++){
            if (arr[i]==0)
                answer+=i;
        }
        
        return answer;
            
    }
}