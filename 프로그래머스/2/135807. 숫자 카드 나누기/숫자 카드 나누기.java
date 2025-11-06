import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for (int i=1;i<arrayA.length;i++){
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        int answer = 0;
        if (!isDiv(gcdA, arrayB)) answer = gcdA;
        if (!isDiv(gcdB, arrayA)) answer = Math.max(answer, gcdB);
        return answer;
    }
    
    private static boolean isDiv(int num, int[] arr){
        for (int x : arr){
            if (x%num==0) return true;
        }
        return false;
    }
    
    private static int gcd(int a, int b){
        if (b==0) return a;
        return gcd(b, a%b);
    }
}
