class Solution {
    public int solution(int[] numbers, int k) {
       int ind = (k-1)*2;
        if (ind>numbers.length)
            ind = ind%numbers.length;
        return numbers[ind];
    }
}