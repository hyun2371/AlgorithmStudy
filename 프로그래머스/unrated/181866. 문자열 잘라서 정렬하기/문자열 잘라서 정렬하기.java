import java.util.*;

class Solution {
    public String[] solution(String myString) {
        
        String[] arr = myString.replace("x"," ").split(" ");
        
        List<String> lst = new ArrayList<>();
        Arrays.sort(arr);
        
        for (String s : arr){
            if (!s.equals(""))
                lst.add(s);
        }
        
        String[] answer = new String[lst.size()];
        for (int i =0;i<lst.size();i++){
            answer[i] = lst.get(i);
        }
        
        return answer;
    }
}