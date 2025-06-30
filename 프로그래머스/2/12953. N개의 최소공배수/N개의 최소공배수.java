class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        //answer와 num의 최대 공약수 제외하고 answer에 곱해줌
        for (int num : arr){
            int g = gcd(Math.max(num, answer), Math.min(num,answer));
            answer = answer * (num/g);
        }
        return answer;
    }
    
    private int gcd(int a, int b){
        if (b==0) return a;
        return gcd(b,a%b);
    }
}