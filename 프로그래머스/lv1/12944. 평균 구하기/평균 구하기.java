import java.util.stream.*;
import java.util.*;
class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        for (int n : arr){
            sum+=n;
        }
        return 1.0*sum/arr.length;
    }
}