import java.util.*;
class Solution {
    public int solution(int balls, int share) {
        share = Math.min(share, balls-share);
        return combination(balls, share);
    }
    
    public int combination(int n, int r){
        if (n==r||r==0) return 1;
         return combination((n - 1), (r - 1)) + combination(n - 1, r);
    }
}