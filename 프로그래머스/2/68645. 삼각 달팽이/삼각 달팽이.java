class Solution {
    final static int[] dx = {1,0,-1}; // 아래, 위, 왼쪽위
    final static int[] dy = {0,1,-1};
    
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][n];
        int x = 0, y=0, cnt = 1, d = 0;
        
        while (true){
            arr[x][y] = cnt++;
            int nx = x+dx[d];
            int ny = y+dy[d];
            
            if (nx==n||ny==n||nx<0||ny<0||arr[nx][ny]!=0){ // 범위 넘어가거나 이미 방문
                d = (d+1)%3; // 방향 바꿈
                nx = x+dx[d]; // 방향 반영해 다시 계산
                ny = y+dy[d];
                if (nx==n||ny==n||nx<0||ny<0||arr[nx][ny]!=0) //범위 변경해도 같음 -> 다 채움
                    break;
            }
            x=nx;
            y=ny;
        }
        
        for (int i=0, ind=0;i<n;i++){
            for (int j=0;j<=i;j++){
                answer[ind++] = arr[i][j];
            }
        }
        return answer;
    }
}