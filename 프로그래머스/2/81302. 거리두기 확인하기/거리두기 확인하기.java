class Solution {
    static char[][] arr = new char[5][5];
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i=0;i<5;i++){
            String[] place = places[i];
            for (int j=0;j<5;j++){
                arr[j] = place[j].toCharArray();
            }
            answer[i] = isDistanced()?1:0;
        }

        return answer;
    }
    
    private static boolean isDistanced(){
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                if (arr[i][j]!='P') continue;
                if (!isDistanced(i,j)) return false;
            }
        }
        return true;
    }
    
    
    
    private static boolean isDistanced(int x, int y){ // 맨해튼 거리 검사
        for (int d=0;d<4;d++){
            int nx = x+dx[d];
            int ny= y+dy[d];
            
            if (nx<0||ny<0||nx>=5||ny>=5) continue;
            
            switch(arr[nx][ny]){
                case 'P': return false;
                case 'O':
                    if (isNextToVolunteer(nx,ny,3-d)) //인접한 곳에 다른 응시자 있는지 검사
                        return false;
                    break;
            }
        }
        return true;
    }
    
    private static boolean isNextToVolunteer(int x, int y, int exclude){
        for (int d=0;d<4;d++){
            if (d==exclude) continue;
            
            int nx = x+dx[d];
            int ny = y+dy[d];
            
            if (nx<0||ny<0||nx>=5||ny>=5) continue;
            if (arr[nx][ny]=='P') return true;
        }
        return false;
    }
}