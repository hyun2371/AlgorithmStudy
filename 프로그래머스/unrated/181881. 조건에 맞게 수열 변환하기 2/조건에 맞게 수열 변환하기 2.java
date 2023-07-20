import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int[] tmp = new int[arr.length];
        int answer=0;
        boolean changed = false;
        while (!Arrays.equals(arr,tmp)){
            if (answer>0)
                arr = Arrays.copyOf(tmp,tmp.length);
            for (int i=0;i<arr.length;i++){
                if (arr[i]>=50&&arr[i]%2==0){
                    tmp[i] = arr[i]/2;
                    changed=true;
                }     
                else if (arr[i]<50&&arr[i]%2!=0){
                    tmp[i]= arr[i]*2+1;
                    changed=true;
                }  
            }
            if (!changed) return 0;
            answer++;
        }
        return answer-1;
    }
}