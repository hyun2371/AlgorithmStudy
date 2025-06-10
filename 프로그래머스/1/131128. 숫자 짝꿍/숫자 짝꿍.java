import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        int[] cnt1 = new int[10];// 인덱스가 몇 번 나왔는지
        int[] cnt2 = new int[10];
        initCnt(cnt1, X);
        initCnt(cnt2, Y);
        
        StringBuilder sb = new StringBuilder();
        for (int i=9;i>=0;i--){
            int interCnt = Math.min(cnt1[i],cnt2[i]); //교집합
            while (interCnt-- >0){
                sb.append(i);
            }
        }
          
        if (sb.length()==0) return "-1";
        if (sb.charAt(0)=='0') return "0";
        
        return sb.toString();
    }
    
    private static void initCnt(int[] cnt, String s){
        for (char c : s.toCharArray()){
            cnt[c-'0']++;
        }
    }  
}