class Solution {
    public int solution(String s) {
        String[] numArr = {"zero", "one", "two", "three", "four", "five",
                       "six", "seven", "eight", "nine"};
        for (int i=0;i<10;i++){
            s = s.replaceAll(numArr[i],String.valueOf(i));
        }
        return Integer.valueOf(s);
    }
}