class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][n];
        int x = 0, y=0, cnt = 1;
        
        while (true){
            while (true){
                arr[x][y] = cnt++;
                if (x+1==n||arr[x+1][y]!=0) break;
                x++;
             }
            
            if (y+1==n||arr[x][y+1]!=0) break;
            y++;
            
            while (true){
                arr[x][y] = cnt++;
                if (y+1==n||arr[x][y+1]!=0) break;
                y++;
            }
            if (arr[x-1][y-1]!=0) break;
            x--; y--;
            
            while (true){
                arr[x][y] = cnt++;
                if (arr[x-1][y-1]!=0) break;
                x--;y--;
            }
            
            if (x+1==n||arr[x+1][y]!=0) break;
            x++;
        }
        
        for (int i=0, ind=0;i<n;i++){
            for (int j=0;j<=i;j++){
                answer[ind++] = arr[i][j];
            }
        }
        return answer;
    }
}