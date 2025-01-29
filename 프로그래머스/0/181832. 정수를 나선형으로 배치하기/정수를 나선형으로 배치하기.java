class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int cnt = 1;
        int rStart = 0, cStart = 0, rEnd = n-1, cEnd = n-1;

        while (cnt <= n * n) {
            for (int i = cStart; i <= cEnd; i++) {
                answer[rStart][i] = cnt++;
            }
            rStart++; 
           
            for (int i = rStart; i <= rEnd; i++) {
                answer[i][cEnd] = cnt++;
            }
            cEnd--; 

           
            for (int i = cEnd; i >= cStart; i--) {
                answer[rEnd][i] = cnt++;
            }
            rEnd--; 

        
            for (int i = rEnd; i >= rStart; i--) {
                answer[i][cStart] = cnt++;
            }
            cStart++; 
        }

        return answer;
    }
}