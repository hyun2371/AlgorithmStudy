import java.util.*;
class Solution {
    static int N,M;
    static int[][] board;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int sum;
    static List<Integer> days = new ArrayList<>();
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        board = new int[N][M];
        initBoard(maps);
        
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (board[i][j]>0) {
                    DFS(i,j);
                    days.add(sum);
                    sum=0;
                } 
            }
        }
        
        if (days.isEmpty()) return new int[]{-1};
        Collections.sort(days);
        int[] answer = new int[days.size()];
        for (int i=0;i<days.size();i++){
            answer[i] = days.get(i);
        }
        return answer;
    }
    
    static void initBoard(String[] maps){
        for (int i=0;i<N;i++){
            String s = maps[i];
            for (int j=0;j<M;j++){
                char c = s.charAt(j);
                if (c=='X') board[i][j] = -1;
                else board[i][j] = c-'0';
            }
        }
    }
    
    static void DFS(int x, int y){
        sum+=board[x][y];
        board[x][y] = 0; //방문 처리
        for (int d=0;d<dx.length;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if (!inRange(nx,ny)||board[nx][ny]<=0) continue;
            DFS(nx,ny);
        }
    }
    
    static boolean inRange(int x, int y){
        return x>=0&&x<N&&y>=0&&y<M;
    }
}