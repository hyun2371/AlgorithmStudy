import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] array, int n) {
        int min = 100;

        for (int i = 0;i<array.length;i++){
            if (Math.abs(array[i]-n) < Math.abs(min-n)){
                min=array[i];
            }
            else if (Math.abs(array[i]-n)==Math.abs(min-n)){
                min=Math.min(min,array[i]);
            }
        }
        return min;
    }
}