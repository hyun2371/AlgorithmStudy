import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        int[] sc = new int[score.length];
        
        for (int i=0;i<score.length;i++){
            sc[i] = score[i][0]+score[i][1];
        }
        
        for (int i=0;i<sc.length;i++){
            for (int j=0;j<sc.length;j++){
                if (sc[i]<sc[j])
                    answer[i]++;
            }
            answer[i]++;
        }
        return answer;
    }
}