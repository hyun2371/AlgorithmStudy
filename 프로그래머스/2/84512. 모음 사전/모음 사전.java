import java.util.*;
class Solution {
    static int cnt = 0;
    static char[] mo  = {'A','E','I','O','U'};
    static boolean flag;
    public int solution(String word) {
        DFS(0,"",word);
        return cnt;
    }
    
    private static void DFS(int lv, String s, String word){
        if (flag||lv==mo.length+1) return;
        if (word.equals(s)) {
            flag = true;
            return;
        }
         cnt++;
        for (int i=0;i<mo.length;i++){
            DFS(lv+1,s+mo[i],word);
        }
    }
}