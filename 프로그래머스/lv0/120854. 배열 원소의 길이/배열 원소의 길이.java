import java.util.*;
class Solution {
    public int[] solution(String[] strlist) {
        int[] arr = new int[strlist.length];
        int index=0;
       for (String s : strlist){
           arr[index++] = s.length();
       }
        return arr;
    }
}