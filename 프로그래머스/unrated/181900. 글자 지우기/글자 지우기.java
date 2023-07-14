import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder(my_string);
        Arrays.sort(indices);
        for (int i = indices.length-1;i>-1;i--){
            sb.deleteCharAt(indices[i]);
        }
        return sb.toString();
    }
}