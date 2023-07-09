import java.util.stream.*;
import java.util.*;
class Solution {
    public int[] solution(int start, int end) {
        return IntStream.rangeClosed(start,end).toArray();
    }
}