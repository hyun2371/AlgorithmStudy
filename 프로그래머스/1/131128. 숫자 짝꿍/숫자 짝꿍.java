import java.util.*;
class Solution {
    static int[] cnt1 = new int[10];
    static int[] cnt2 = new int[10];
    public String solution(String X, String Y) {
        initCnt1(X);
        initCnt2(Y);
        
        StringBuilder sb = new StringBuilder();
        for (int i=9;i>=0;i--){
            int interCnt = Math.min(cnt1[i],cnt2[i]);
            while (interCnt-- >0){
                if (i==0&&sb.length()==0) return "0"; // 0이 최초로 나오는 경우
                sb.append(i);
            }
        }
        if (sb.length()==0) return "-1";
        
        return sb.toString();
    }
    
    private static void initCnt1(String X){
        for (char c : X.toCharArray()){
            cnt1[c-'0']++;
        }
    } 
    
    private static void initCnt2(String Y){
        for (char c : Y.toCharArray()){
            cnt2[c-'0']++;
        }
    } 
}