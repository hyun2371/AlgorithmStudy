import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int answer = 0;

        Arrays.sort(sides);
        int n = 1;
        
        //n이 가장 크지 않을 경우
        while (n<sides[1]){
            if (n+sides[0]>sides[1]){
                answer++;
            }
            n++;
        }
        //n이 가장 클 경우
        while (n<sides[0]+sides[1]){
            answer++; n++;
        }
        return answer;
    }
}