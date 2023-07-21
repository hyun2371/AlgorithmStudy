import java.util.*;
class Solution {
    public int[][] solution(int[][] arr) {
        int a_l = Math.max(arr.length,arr[0].length); //answer길이
        int[][] answer = new int[a_l][a_l];
        
        for (int i =0;i<arr.length;i++){
            for (int j =0;j<arr[i].length;j++){
                answer[i][j] = arr[i][j];
            }
        }
        return answer;      
    }
}