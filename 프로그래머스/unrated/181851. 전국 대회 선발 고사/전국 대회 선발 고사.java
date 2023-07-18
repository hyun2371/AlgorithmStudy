import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] arr = new int[3];
        int r =1; int ind = 0;

        while (ind<3){
            for (int i =0;i<rank.length;i++){
                if (rank[i]==r){
                    if (attendance[i]){
                       arr[ind++]=i; r++;  break;
                    } else{
                        r++; break;
                    }    
                }    
            }
        }
        return arr[0]*10000+arr[1]*100+arr[2]*1;
    }
}