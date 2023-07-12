import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        /*
        sort하기
        뒤의 두개 앞의 두개 곱한 뒤 비교
        */
        Arrays.sort(numbers);
        return Math.max(numbers[0]*numbers[1]
                ,numbers[numbers.length-2]*numbers[numbers.length-1]);
    }
}