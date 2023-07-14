class Solution {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.reverse();
        for (int i = 0;i<sb.length();i++){
            answer[i] = sb.charAt(i)-48;
        }
        return answer;
    }
}