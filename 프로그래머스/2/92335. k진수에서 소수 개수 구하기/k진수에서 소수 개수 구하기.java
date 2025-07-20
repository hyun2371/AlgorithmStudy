import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int cnt = 0;

        String numK = Integer.toString(n,k);
        String[] subset = numK.split("0+");
        for (String num : subset){
            if (num.equals("")) continue;
            if (isPrime(Long.parseLong(num))) cnt++;
        }
     
        return cnt;
    }
    
    private static boolean isPrime(long num){ //소수여부 판별
        if (num<2) return false;
        for (long i=2;i*i<=num;i++){
            if (num%i==0) return false;
        }
        return true;
    }
}