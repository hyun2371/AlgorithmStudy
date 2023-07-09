class Solution {
    public int solution(int a, int b) {
        if (a%2==0&&b%2==0){
            return a-b>=0?a-b:-1*(a-b);
        } else if (a%2!=0&&b%2!=0){
            return a*a+b*b;
        } else {
            return 2*(a+b);
        }
    }
}