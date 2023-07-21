class Solution {
    public int solution(int n) {
        int answer = 1; int cnt = 1;
        
        while (cnt!=n){
            boolean isContains = false;
            answer++;
            if (answer%3==0)
                continue;
            
            int tmp = answer;
            while (tmp!=0){
                if (tmp%10==3){
                    isContains = true; break;
                }
                tmp/=10;
            }
            if (isContains) continue;
            
            cnt++;
        }
        return answer;
    }
}