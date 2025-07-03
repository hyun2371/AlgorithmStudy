import java.util.*;
class Solution {
    
    static List<String> lst = new ArrayList<>();
    static StringBuilder sb  = new StringBuilder();
    static String[] arr = {"A","E","I","O","U"};
    public int solution(String word) {
        DFS(0);
        return lst.indexOf(word)+1;
    }
    
    private static void DFS(int lv){
        if (lv==5){
            return;
        }
        for (int i=0;i<5;i++){
            sb.append(arr[i]);
            lst.add(sb.toString());
            DFS(lv+1);
            sb.setLength(sb.length() - 1);
        }
    }
}