import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int r=0;r<answer.length;r++){
            int i = commands[r][0]-1, j = commands[r][1]-1, k = commands[r][2]-1;
            int[] tmp = Arrays.copyOfRange(arr,i,j+1);
            sort(tmp); // 정렬
            answer[r] = tmp[k]; // k번째 추출
        }
        return answer;
    }
    
    // 삽입 정렬
    public static void sort(int[] tmp){
        for (int i=1;i<tmp.length;i++){
            int target = tmp[i], j;
            for (j=i-1;j>=0;j--){
                if (tmp[j]>target) tmp[j+1] = tmp[j];
                else break;
            }
            tmp[j+1] = target;
        }
    }
}