class Solution {
    public int solution(int num) {
        int cnt = 0;
        long n = (long)num;
        while (n!=1){
            if (cnt==500) return -1;
            if(n%2==0){
                n/=2;
            } else {
                n=n*3+1;
            }
            cnt++;
        }
        return cnt;
    }
}