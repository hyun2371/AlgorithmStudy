import java.util.*;
class Solution {
    
    static List<String> lst = new ArrayList<>();
    static StringBuilder sb  = new StringBuilder();
    static String[] arr = {"A","E","I","O","U"};
    public int solution(String word) {
        DFS(0,word);
        return lst.indexOf(word)+1;
    }
    
    private static void DFS(int lv,String word){
        if (lv==5){
            return;
        }
        for (int i=0;i<arr.length;i++){
            sb.append(arr[i]);
            lst.add(sb.toString());
            if (sb.toString().equals(word)) return;
            DFS(lv+1,word);
            sb.setLength(sb.length() - 1);
        }
    }
}