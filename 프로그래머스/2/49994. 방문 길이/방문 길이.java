import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static final int LEN = 11; //5*2+1
    static Set<String> set = new HashSet<>();
    static int x=0,y=0;
    public int solution(String dirs) {
        for (char dir:dirs.toCharArray()){
            move(dir);
        }
        for (String s : set){
            System.out.println(s);
        }
        return set.size()/2;
    }
    
    private static void move(char dir){
        int dirNum = getDirNum(dir);
        int nx = x+dx[dirNum];
        int ny = y+dy[dirNum];
        if (!inRange(nx,ny)) return;
        
        String path1 = new StringBuilder().append(x).append(y).append(nx).append(ny).toString();
        String path2 = new StringBuilder().append(nx).append(ny).append(x).append(y).toString();
        set.add(path1);
        set.add(path2);
        x=nx; y=ny;
    }
    
    private static int getDirNum(char dir){
        if (dir=='U') return 0;
        if (dir=='D') return 1;
        if (dir=='R') return 2;
        return 3;
    }
    
    private static boolean inRange(int x, int y){
        return x>=-5&&x<=5&&y>=-5&&y<=5;
    }
}