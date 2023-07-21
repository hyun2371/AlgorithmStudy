class Solution {
    public int solution(int n) {
        int answer = 1; int cnt = 1;
        
        while (cnt!=n){
            answer++;
            if (answer%3==0||String.valueOf(answer).contains("3"))
                continue;
            cnt++;
        }
        return answer;
    }
}