import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0, tmp = 10;
        List<Integer> lst = new ArrayList<>();
        
        for (int i=0;i<score.length;i++)
            lst.add(score[i]);
        Collections.sort(lst);
    
        while (lst.size()>=m){
            for (int i=0;i<m;i++){
                tmp = Math.min(lst.get(lst.size()-1),tmp);
                lst.remove(lst.size()-1);
                
            }
            answer+=tmp*m;
        }
        return answer;
    }
}

