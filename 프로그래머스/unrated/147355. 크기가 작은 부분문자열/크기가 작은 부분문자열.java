class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i=0;i<=t.length()-p.length();i++){
            Long n = Long.valueOf(t.substring(i,i+p.length()));
            if (n<=Long.valueOf(p)) {
                answer++;
            }
        }
        return answer;
    }
}