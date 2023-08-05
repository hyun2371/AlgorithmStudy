import java.util.*;
class Solution {
    public String solution(int[] food) {
        int n=0; StringBuilder sb = new StringBuilder();
        
        for (int i=1;i<food.length;i++){
            if (food[i]%2!=0) n = (food[i]-1)/2;
            else n = food[i]/2;
            sb.append(String.valueOf(i).repeat(n));
        }
        
         return sb.toString()+"0"+sb.reverse();
    }
}