import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        
        int[] attacks = new int[number+1];
        
        for (int i=1;i<=number;i++){
            attacks[i] = getCnt(i);
        }
        
        int total = 0;
        for (int i=1;i<=number;i++){
            if (attacks[i]>limit) total+=power;
           else total+=attacks[i];
        }

        return total;
    }
    
    private static int getCnt(int n){
        int cnt = 0;
        for (int i=1;i<=Math.sqrt(n);i++){
            if (n%i==0){
                cnt++;
                if (i!=n/i) cnt++;
            }
        }
        return cnt;
    }
}
/*
공격력-> 약수의 개수
공격력 > limit -> 공격력 = power
공격력 총합
*/