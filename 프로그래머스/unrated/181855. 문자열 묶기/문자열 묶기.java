import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String[] strArr) {

        int[] lenArr = new int[strArr.length];
        for (int i = 0 ;i<strArr.length;i++){
            lenArr[i] = strArr[i].length();
        }
        
        
        int max = 0; 
        for (int i = 1; i<=30;i++){
            int count = 0;
            for (int n : lenArr){
                if (n==i){
                    count++;
                }
            }
            if (count>max) max = count;
        }
        return max;
    }
}