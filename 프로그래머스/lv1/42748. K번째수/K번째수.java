import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int r = 0; r<commands.length;r++){
            int i=commands[r][0]-1, j = commands[r][1]-1, k = commands[r][2]-1;
            int[] tmp = Arrays.copyOfRange(array,i,j+1);
            Arrays.sort(tmp);
            answer[r] = tmp[k];
        }
        return answer;
    }
}