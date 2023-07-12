import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int answer = 0;

        Arrays.sort(sides);
        for (int i =1;i<sides[0]+sides[1];i++){
            if (i+sides[0]>sides[1]){ //i가 제일 긺
                answer++;
            }
            else if (sides[0]+sides[1]<i){//i가 제일 길지 않음
                answer++;
            }
        }
        return answer;
    }
}