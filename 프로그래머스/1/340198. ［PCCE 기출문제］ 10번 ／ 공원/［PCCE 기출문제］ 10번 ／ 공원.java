import java.util.*;
class Solution {
    static int N,M;
    public int solution(int[] mats, String[][] park) {
        N = park.length;
        M = park[0].length;
        Arrays.sort(mats);
        for (int s = mats.length-1;s>=0;s--){
            for (int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    if (isAvailable(park,i,j,mats[s])) return mats[s];
                }
            }
        }
        
        return -1;
    }
    
    private static boolean inRange(int x, int y){
        return x>=0&&y>=0&&x<N&&y<M;
    }
    
    private static boolean isAvailable(String[][] park, int x, int y, int size){
        for (int i=x;i<x+size;i++){
            for (int j=y;j<y+size;j++){
                if (!inRange(i,j)||!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}