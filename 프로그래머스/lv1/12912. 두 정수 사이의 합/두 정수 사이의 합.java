class Solution {
    public long solution(int a, int b) {
        long answer =0;
        long la = (long)a;
        long lb = (long)b;
        if (a==b) return a;
        if (a>b){
            long tmp = b;
            lb = a;
            la = tmp;
        } 
        for (long i=la;i<=lb;i++)
            answer+=i;
        return answer;
    }
}