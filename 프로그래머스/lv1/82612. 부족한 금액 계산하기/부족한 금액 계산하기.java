class Solution {
    public long solution(int price, int money, int count) {
        /*      
        3 3*2 3*3 3*4
        3*(1+2+3+4)
        3*(n(n+1)/2)
        
        r*(n(n+1)/2)
        */
        long total = price*(((long)count*(count+1))/2);
        if (money-total>0) return 0;
        return total-money;    
    }
}