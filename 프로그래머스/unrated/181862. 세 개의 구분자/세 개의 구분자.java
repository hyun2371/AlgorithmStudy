import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        List<String> lst = new ArrayList<>();
        String[] arr = myStr.replaceAll("a|b|c"," ").split(" ");
    
        if (arr.length==0) return new String[]{"EMPTY"};
        
        for (int i = 0;i<arr.length;i++){
            if (!arr[i].equals("")){
                lst.add(arr[i]);
            }
        }
        
        String[] answer = new String[lst.size()];
        
        for (int i =0;i<answer.length;i++){
            answer[i] = lst.get(i);
        }
        
        return answer;
    }
}