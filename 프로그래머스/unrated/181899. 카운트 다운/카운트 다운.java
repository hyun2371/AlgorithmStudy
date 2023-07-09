import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int start, int end) {
        int index=0;
        int[] arr = new int[start-end+1];
        for (int i = start;i>=end;i--){
            arr[index++] = i;
        }
        return arr;
    }
}