import java.util.*;
class Solution {
    public String solution(String s) {
        String[] s_arr = s.split(" ");
        int len = s_arr.length;
        int[] arr = new int[len];
        for (int i=0;i<len;i++){
            arr[i] = Integer.parseInt(s_arr[i]);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ").append(arr[len-1]);
        return sb.toString();
    }
}