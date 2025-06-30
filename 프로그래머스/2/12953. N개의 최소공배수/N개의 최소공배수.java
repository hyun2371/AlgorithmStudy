import java.util.*;
class Solution {
    static int[] cnt = new int[100];
    public int solution(int[] arr) {
        
        for (int num : arr){
            putCnt(num);
        }
        
       int answer = 1;
       for (int i=1;i<100;i++){
           if (cnt[i]>0) {
               answer*=(int)Math.pow(i,cnt[i]);
           }
       }
        return answer;
    }
    
    private static void putCnt(int num){
        int[] tmp = new int[100];
        while (num!=1){
            for (int i=2;i<=num;i++){
                if (!isPrime(i)) continue;
                if (num%i==0) {
                    tmp[i]++;
                    num/=i;
                }
            }
        }
        
        for (int i=1;i<100;i++){
            if (tmp[i]>0){
                cnt[i] = Math.max(cnt[i],tmp[i]);
            }
        }
        
    }
    
    private static boolean isPrime(int n){
        if (n==1) return true;
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0) return false;
        }
        return true;
    }
}