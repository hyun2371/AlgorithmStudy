import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int min = 100;
        Arrays.sort(array);
        for (int i = 0;i<array.length;i++){
            if (Math.abs(array[i]-n) < Math.abs(min-n)){
                min=array[i];
            }
        }
        return min;
    }
}