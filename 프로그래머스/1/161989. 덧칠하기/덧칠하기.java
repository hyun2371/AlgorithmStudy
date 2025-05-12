import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int cnt = 0, curInd = 1;
        int[] arr = new int[n+1];
        
        for (int x : section){
            arr[x] = 1; //칠해야하는 구역 표시
        }

        while (curInd<=n){
            if (arr[curInd] == 1) {
                cnt++;
                for (int i=curInd;i<curInd+m&&i<=n;i++){//칠하기
                    arr[i] = 0;
                }
                curInd +=m; //칠한 구역 다음부터
            }
            else curInd++;
        }
        return cnt;
    }
}