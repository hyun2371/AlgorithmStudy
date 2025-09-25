import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {

        int minLen = Integer.MAX_VALUE, sIdx = 0, eIdx = 0;
        int lt = 0, rt =0, sum = arr[lt];
        
        while (lt<=rt&&rt<arr.length){
            if (sum==k){
                int len = rt-lt+1;
                if (len<minLen){
                    sIdx = lt;
                    eIdx = rt;
                    minLen = len;
                }
                sum-=arr[lt];
                lt++;
            }
            else if (sum<k){
                rt++;
                if(rt==arr.length) break;
                sum+=arr[rt];
            }
            else if (sum>k){
                sum-=arr[lt];
                lt++;
            }
        }
        return new int[]{sIdx,eIdx};
    }
}