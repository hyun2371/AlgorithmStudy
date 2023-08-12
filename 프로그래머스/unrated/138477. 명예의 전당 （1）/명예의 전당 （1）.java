import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int answer[] = new int[score.length];
        List<Integer> lst = new ArrayList<>();
        
        for (int i=0;i<score.length;i++){
            lst.add(score[i]);
            Collections.sort(lst);
            if (i>=k)
                lst.remove(lst.get(0));
            answer[i] = lst.get(0);
        }
        return answer;
    }
}
