import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        return Arrays.stream(arr).map(x->k%2==0?x+k:x*k).toArray();
    }
}