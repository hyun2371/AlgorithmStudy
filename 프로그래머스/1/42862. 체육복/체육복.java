import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] cnt = new int[n+1]; //체육복 보유 개수  1여분 0자기꺼만 -1분실
        
        for (int ind : lost){//분실
            cnt[ind]--;
        }
        for (int ind : reserve){//여분
            cnt[ind]++;
        }
        
        for (int i=1;i<=n;i++){
            if (cnt[i]>=0) continue;
            if (i>1&&cnt[i-1]>0) cnt[i-1]--;
            else if (i<n&&cnt[i+1]>0) cnt[i+1]--;
            else answer--;
        }
        
        return answer;
    }
}