class Solution {

    public long solution(int n) {
        long[] d = new long[n+1];
        if (n==1) return 1;
        if (n==2) return 2;
        d[1] = 1;
        d[2] = 2;
        
        for (int i=3;i<=n;i++){
            d[i] = (d[i-2]+d[i-1])%1234567;
        }        
        
        return d[n];
    }
    

}