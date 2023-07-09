import java.util.*;
class Solution {
    public String solution(String my_string, String alp) {
        char[] arr = my_string.toCharArray();
        char cAlp = alp.charAt(0);
        for (int i=0;i<arr.length;i++){
            if (arr[i] ==cAlp){
                arr[i] = Character.toUpperCase(cAlp);
            }
        }
        return String.valueOf(arr);
    }
}