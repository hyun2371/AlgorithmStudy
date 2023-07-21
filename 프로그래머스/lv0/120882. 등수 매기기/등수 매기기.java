import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        List<Integer> lst = new ArrayList<>();
        for (int i=0;i<score.length;i++){
            lst.add(score[i][0]+score[i][1]);
        }
        Collections.sort(lst,Collections.reverseOrder());
        
        int[] answer = new int[score.length];
        for (int i=0;i<score.length;i++){
            answer[i] = lst.indexOf(score[i][0]+score[i][1])+1;
        }
        return answer;
    }
}