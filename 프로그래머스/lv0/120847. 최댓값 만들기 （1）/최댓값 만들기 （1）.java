import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] numbers) {
        IntStream sorted = Arrays.stream(numbers).sorted();
        int[] sortedArr = sorted.toArray();
        return sortedArr[numbers.length-1]*sortedArr[numbers.length-2];
    }
}