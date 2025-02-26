import java.util.*;
class Solution {
    static int[] dx= {-1,1,0,0};
    static int[] dy= {0,0, -1, 1};
    static int R,C,cnt;
    static char[][] graph;
    
    public int[] solution(String[] maps) {
        initGraph(maps);
        List<Integer> lst = new ArrayList<>();
        
        for (int i=0;i<R;i++){
            for (int j = 0;j<C;j++){
                if (graph[i][j]!='X') {
                    cnt = graph[i][j]-'0';
                    graph[i][j] = 'X';
                    DFS(i,j);
                }
                if (cnt>0) lst.add(cnt);
                cnt = 0;
            }
        }
        
        return getAnswer(lst);
    }
    
    
    private static void DFS(int x, int y){
        for (int d=0;d<4;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            
            if (nx<0||ny<0||nx>=R||ny>=C) continue;
            if (graph[nx][ny]=='X') continue;
            cnt+=graph[nx][ny]-'0';
            graph[nx][ny] = 'X';
            DFS(nx,ny);
        }
    }
    
    
    private static int[] getAnswer(List<Integer> lst){
         if (lst.isEmpty()) lst.add(-1);
        int[] answer = new int[lst.size()];
        
        Collections.sort(lst);
        for (int i=0;i<lst.size();i++){
            answer[i] = lst.get(i);
        }
        
        return answer;
    }
    
    private static void initGraph(String[] maps){
        R = maps.length;
        C = maps[0].length();
        graph = new char[R][C];
        
        for (int i=0;i<R;i++){
            graph[i] = maps[i].toCharArray();
        }
    }
    
}