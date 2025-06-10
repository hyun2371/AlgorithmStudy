import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> remains = new HashSet<>();
        
        int zCnt = 0; //0개수
        for (int lotto:lottos){
            if (lotto==0) zCnt++;
            else remains.add(lotto); //set에 로또 번호 추가
        }
        
        for (int key:win_nums){
            if (remains.contains(key)) remains.remove(key); //번호 맞추면 제거
        }
        
        answer[0] = getRank(6-remains.size()); //최고
        answer[1] = getRank(6-remains.size()-zCnt);  //최저
        
        return answer;
    }
    
    private static int getRank(int correctCnt){
        if (correctCnt<=1) return 6;
        return 6-correctCnt+1;
    }
}