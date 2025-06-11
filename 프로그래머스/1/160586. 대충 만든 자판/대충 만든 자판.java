import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] cnt = new int[26]; //i번째 알파벳 자판치는 최소 횟수
        Arrays.fill(cnt,Integer.MAX_VALUE);
        for (int i=0;i<keymap.length;i++){
            String key = keymap[i];
            for (int j=0;j<key.length();j++){
                int cntInd = key.charAt(j)-'A';
                cnt[cntInd] = Math.min(cnt[cntInd],j+1);
            }
        }
        
        for (int i=0;i<targets.length;i++){
            String target = targets[i];
            for (char c : target.toCharArray()){
                if (cnt[c-'A']==Integer.MAX_VALUE){
                    answer[i] = -1; break;
                }
                answer[i]+=cnt[c-'A'];
            }
        }
        return answer;
    }
    
    
}