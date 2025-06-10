class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M, cnt=0;
    static String target;
    
    public int solution(String[][] board, int h, int w) {
        N = board.length; 
        M = board[0].length;

        target = board[h][w];
        count(h,w,board);
        
        return cnt;
    }
    
    private static void count(int x, int y, String[][] board){
        for (int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (!inRange(nx,ny)) continue;
            if (!board[nx][ny].equals(target)) continue;
            cnt++;
        }
    }
    
    private static boolean inRange(int x, int y){
        return x>=0&&y>=0&&x<N&&y<M;
    }
}