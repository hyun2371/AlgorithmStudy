class Solution {
    public int[] solution(int n, int m) {
       if (n<m){
           int tmp = n;
           n = m;
           m=tmp;
       }
        int a = 1;
        for (int i =2;i<=n;i++){
            if (m%i==0&&n%i==0){
                a=i;
            }
        }
        int b = n;
        while (true){
            if (b%n==0&&b%m==0) break;
            b++;
        }
        
        return new int[]{a,b};
    }
}