import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length>arr2.length){
            return 1;
        } else if (arr1.length<arr2.length){
            return -1;
        }
        return Integer.compare(Arrays.stream(arr1).sum(),Arrays.stream(arr2).sum());
    }
}