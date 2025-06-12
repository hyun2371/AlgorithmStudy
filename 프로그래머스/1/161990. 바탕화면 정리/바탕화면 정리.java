import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE; //최소x
        int luy = Integer.MAX_VALUE; //최소y
        int rdx = Integer.MIN_VALUE; //최대x
        int rdy = Integer.MIN_VALUE; //최대 y
        for (int i=0;i<wallpaper.length;i++){
            String row = wallpaper[i];
            for (int j=0;j<row.length();j++){
                if (row.charAt(j)=='#'){
                    lux = Math.min(i,lux);
                    luy = Math.min(j,luy);
                    rdx = Math.max(i,rdx);
                    rdy = Math.max(j,rdy);
                }
            }
        }
        return new int[]{lux,luy,rdx+1,rdy+1};
    }
}