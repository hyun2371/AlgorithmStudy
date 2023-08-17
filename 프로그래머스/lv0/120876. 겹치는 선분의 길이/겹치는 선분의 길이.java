import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] arr = new int[201];
        for (int i=0;i<lines.length;i++){
            int start = lines[i][0], end = lines[i][1];
            for (int ind=start; ind< end;ind++){
                if (arr[ind+100]==1){
                    answer++; 
                    arr[ind+100]=-1; //중복 제거
                } 
                else arr[ind+100]=1;
                System.out.println(answer);
            }
        }
        return answer;
    }
}