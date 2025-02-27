import java.util.*;
class Solution {
    static int[] mem;
    public int solution(int n) {
       mem = new int[n+1];
      return fibo(n);
    }
    
    private static int fibo(int n){
        if (mem[n]>0) return mem[n];
        if (n==0) return mem[n] = 0;
        if (n==1) return mem[n] = 1;
        return mem[n] = (fibo(n-1)+fibo(n-2))%1234567;
    }
}