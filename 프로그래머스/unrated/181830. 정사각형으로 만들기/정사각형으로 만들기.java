import java.util.*;
class Solution {
    public int[][] solution(int[][] arr) {
        int a_l = Math.max(arr.length,arr[0].length); //answer길이
        int r_l = Math.min(arr.length, arr[0].length);//min(r,c)
        int[][] answer = new int[a_l][a_l];
        
        for (int i =0;i<a_l;i++){
            for (int j =0;j<a_l;j++){
                if (arr.length>arr[0].length&&j>=r_l){
                    answer[i][j] = 0;
                } else if (arr.length<arr[0].length&&i>=r_l){
                    answer[i][j] = 0;
                } else {
                    answer[i][j] = arr[i][j];
                }      
            }
        }
        return answer;      
    }
}