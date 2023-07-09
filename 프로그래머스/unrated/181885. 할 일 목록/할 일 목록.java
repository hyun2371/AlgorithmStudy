import java.util.*;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> lst = new ArrayList<>();
        for (int i = 0;i<finished.length;i++){
            if (finished[i]==false){
                lst.add(todo_list[i]);
            }
        }
        return lst.toArray(new String[lst.size()]);
    }
}