import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        List<String> lst = new ArrayList<>();
        String newStr = myStr.replace("a"," ");
        newStr = newStr.replace("b"," ");
        newStr = newStr.replace("c", " ");
        String[] arr = newStr.split(" ");
    
        if (arr.length==0) return new String[]{"EMPTY"};
        
        for (int i = 0;i<arr.length;i++){
            if (!arr[i].equals("")){
                lst.add(arr[i]);
            }
        }
        
        String[] answer = lst.toArray(new String[lst.size()]);
        return answer;
        
    }
}