import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int cnt = 0;
        Queue<Character> q = new LinkedList<>();
        String num = "";
        for (char x : Integer.toString(n,k).toCharArray()){
            if (x=='0') {
                if (!q.isEmpty()) {
                    num = "";
                    while (!q.isEmpty()){
                        num += q.poll();
                    }
                    if (!num.equals("") && isPrime(Long.parseLong(num))) cnt++;
                }
            } else {
                q.offer(x);
            }
        }
        if (!q.isEmpty()) {
            num = "";
            while (!q.isEmpty()) {
                num += q.poll();
            }
            if (!num.equals("") && isPrime(Long.parseLong(num))) cnt++;
        }
        return cnt;
    }
    private static boolean isPrime(long num){
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++){
            if (num % i == 0) return false;
        }
        return true;
    }
}