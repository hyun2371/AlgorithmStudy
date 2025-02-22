class Solution {
    public int[] solution(long n) {
        String n_str = String.valueOf(n);
        int len = n_str.length();
        int[] answer = new int[n_str.length()];
        for (int i=0;i<len;i++){
            answer[i] = n_str.charAt(len-i-1)-'0';
        }
        return answer;
    }
}