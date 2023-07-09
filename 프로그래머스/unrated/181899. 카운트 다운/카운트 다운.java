import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int start, int end) {
        int[] arr = new int[start-end+1];
        for (int i = 0;i<start-end+1;i++){
            arr[i] = start-i;
        }
        return arr;
    }
}