import java.util.*;
class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        String tmp = A;

        for (int i = 0; i < A.length(); i++) {
            if (tmp.equals(B)) {
                return answer;
            }
            answer++;
            String tail = tmp.substring(A.length() - 1);
            tmp = tail + tmp.substring(0, A.length() - 1);
            
        }

        return -1;
    }
}