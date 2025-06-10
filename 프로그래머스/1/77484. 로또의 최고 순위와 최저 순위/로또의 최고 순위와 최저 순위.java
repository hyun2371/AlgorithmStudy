import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> remains = new HashSet<>();
        int zCnt = 0; //0개수
        int correctCnt = 0;
        
        for (int lotto:lottos){
            if (lotto==0) zCnt++;
            else remains.add(lotto);
        }
        
        for (int key:win_nums){
            if (remains.contains(key)) {
                correctCnt++;
            }
        }
        
        answer[0] = getRank(correctCnt+zCnt); //최고
        answer[1] = getRank(correctCnt);  //최저
        
        return answer;
    }
    
    private static int getRank(int correctCnt){
        if (correctCnt<=1) return 6;
        return 6-correctCnt+1;
    }
}