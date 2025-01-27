import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        int[] arr = new int[n+1];
        for (int ind : lost){
            arr[ind]--;
        }
        for (int ind: reserve){
            arr[ind]++;
        }
        for (int i=1;i<=n;i++){
            if (arr[i]>-1) count++;
            else {
                if (arr[i-1]==1){ // 왼쪽에서 빌림
                    arr[i-1]--; count++; continue;
                }
                if (i+1<=n&&arr[i+1]==1){ // 오른쪽에서 빌림
                    arr[i+1]--; count++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return count;
    }
}