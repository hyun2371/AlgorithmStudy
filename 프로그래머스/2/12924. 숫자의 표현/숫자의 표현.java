class Solution {
    public int solution(int n) {
        int sum = 0, lt = 0, cnt=0;
        for (int rt=1;rt<=n;rt++){
            sum+=rt;
            while (sum>n){
                sum-=lt;
                lt++;
            }
            if (sum==n) cnt++;
        }
        return cnt;
    }
}